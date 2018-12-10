package com.base.process;

import com.base.annotations.GqlSchemaField;
import com.base.annotations.GqlSchemaTypeDef;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.base.process.GqlSchemaGeneratorUtils.getBeanDefinitions;
import static com.base.process.GqlSchemaGeneratorUtils.lookupDefaultSupportedType;
import static com.base.process.GqlSchemaGeneratorUtils.lookupSupportedTypeOrDefault;

public class GqlSchemaModelGenerator implements GqlSchemaGenerator {

    private static Set<String> modelBeanDefinitionNames = new HashSet<>();

    public GqlSchemaModelGenerator() {}

    @Override
    public String generateDefinition(String basePackage) {
        //TODO create a DAG here, go through beandefinitions referred in the model classes
        //choose the one with no outgoing edges first to generate type info and then backtrack
        final Set<BeanDefinition> modelBeanDefinitions = getBeanDefinitions(basePackage, GqlSchemaTypeDef.class);
        modelBeanDefinitionNames = modelBeanDefinitions.stream().map(BeanDefinition::getBeanClassName).collect(Collectors.toSet());
        StringBuilder sb = new StringBuilder();
        for (final BeanDefinition beanDef : modelBeanDefinitions) {
            sb.append(buildModelDefinition(beanDef));
        }
        return sb.toString();
    }

    private String buildModelDefinition(final BeanDefinition beanDefinition) {
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> cl = Class.forName(beanDefinition.getBeanClassName());
            sb.append("type ").append(cl.getSimpleName()).append(" { \n ");
            for (Field field : cl.getDeclaredFields()) {
                if (field.isAnnotationPresent(GqlSchemaField.class)) {
                    sb.append(modelStringRepresentation(field));
                    sb.append("\n");
                }
            }
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        return sb.append("\t}\n").toString();
    }

    private String modelStringRepresentation(final Field field) {
        Class<?> clazz = field.getType();
        //check if its one of the classes defined in the model
        if (modelBeanDefinitionNames.contains(field.getType().getName())) {
            return getSupportedTypeStringRep(field.getName(), field.getType().getSimpleName());
        }
        //check if list type
        if (field.getGenericType() instanceof ParameterizedType && List.class.equals(clazz)) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            Class<?> argumentClazz = (Class<?>) genericType.getActualTypeArguments()[0];
            String supportedType = lookupDefaultSupportedType(argumentClazz).orElse(argumentClazz.getSimpleName());
            return getListTypeStringRep(field.getName(), supportedType);
        }
        return getSupportedTypeStringRep(field.getName(), lookupSupportedTypeOrDefault(clazz).get());
    }

    private String getListTypeStringRep(String fieldName, String returnVal) {
        return "\t" + fieldName + ": " +
                "[" + returnVal + "]";
    }

    private String getSupportedTypeStringRep(String fieldName, String returnVal) {
        return "\t" + fieldName + ": " + returnVal;
    }
}
