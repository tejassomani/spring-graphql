package com.base.process;

import com.base.annotations.GqlSchemaQuery;
import com.base.annotations.GqlSchemaQueryDef;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.base.process.GqlSchemaGeneratorUtils.getBeanDefinitions;
import static com.base.process.GqlSchemaGeneratorUtils.lookupDefaultSupportedType;

public class GqlSchemaQueryGenerator implements GqlSchemaGenerator {

    public GqlSchemaQueryGenerator() {}

    @Override
    public String generateDefinition(String basePackage) {
        final Set<BeanDefinition> queryBeanDefinitions = getBeanDefinitions(basePackage, GqlSchemaQueryDef.class);
        final StringBuilder sb = new StringBuilder();
        sb.append("type ").append("Query").append(" { \n ");
        for (final BeanDefinition beanDef : queryBeanDefinitions) {
            sb.append(buildQueryDefinition(beanDef));
        }
        return sb.append("\t}\n").toString();
    }

    private String buildQueryDefinition(BeanDefinition beanDefinition) {
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> cl = Class.forName(beanDefinition.getBeanClassName());

            for (Method method : cl.getDeclaredMethods()) {
                if (method.isAnnotationPresent(GqlSchemaQuery.class)) {
                    sb.append(buildQueryDefinition(method)).append("\n");
                }
            }
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        return sb.toString();
    }

    private String buildQueryDefinition(Method method) {
        final Class<?> clazz = method.getReturnType();
        final String annotationValue = method.getDeclaredAnnotation(GqlSchemaQuery.class).value();
        final String methodName = StringUtils.isEmpty(annotationValue) ? method.getName() : annotationValue;
        final Optional<String> parameterString = buildParametersAsString(method.getParameters());

        if (method.getGenericReturnType() instanceof ParameterizedType && List.class.equals(clazz)) {
            final ParameterizedType genericType = (ParameterizedType) method.getGenericReturnType();
            final Class<?> argumentClazz = (Class<?>) genericType.getActualTypeArguments()[0];
            final String supportedType = lookupDefaultSupportedType(argumentClazz).orElse(argumentClazz.getSimpleName());
            //simplify this if else
            if (parameterString.isPresent()) {
                return "\t" + methodName + parameterString.get() + ": " + "[" + supportedType + "]";
            }
            else {
                return "\t" + methodName + ": " + "[" + supportedType + "]";
            }
        }
        else {
            return "\t" + methodName + parameterString.get() + ": " + method.getReturnType().getSimpleName();
        }
    }

    private Optional<String> buildParametersAsString(final Parameter[] parameters) {
        if (parameters.length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (Parameter parameter : parameters) {
                final String paramType = lookupDefaultSupportedType(parameter.getType()).orElse(parameter.getType().getSimpleName());
                sb.append(parameter.getName()).append(": ").append(paramType);
            }
            return Optional.of(sb.append(")").toString());
        }
        return Optional.ofNullable(null);
    }
}
