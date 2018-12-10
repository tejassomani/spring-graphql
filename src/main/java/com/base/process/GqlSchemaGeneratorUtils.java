package com.base.process;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public abstract class GqlSchemaGeneratorUtils {

    private static Map<Class<?>, String> supportedDefaultFieldTypesMapping = new HashMap<>();
    public static final String DEFAULT_SCHEMA_START_ELEM = "schema {\n" +
            "    query: Query\n" +
            "}\n";

    //Something better to handle this (only Int is different)
    static {
        if (supportedDefaultFieldTypesMapping.isEmpty()) {
            supportedDefaultFieldTypesMapping.put(Integer.class, "Int");
            supportedDefaultFieldTypesMapping.put(int.class, "Int");
            supportedDefaultFieldTypesMapping.put(Float.class, Float.class.getSimpleName());
            supportedDefaultFieldTypesMapping.put(float.class, Float.class.getSimpleName());
            supportedDefaultFieldTypesMapping.put(Boolean.class, Boolean.class.getSimpleName());
            supportedDefaultFieldTypesMapping.put(boolean.class, Boolean.class.getSimpleName());
            supportedDefaultFieldTypesMapping.put(String.class, String.class.getSimpleName());
        }
    }

    private GqlSchemaGeneratorUtils() {}

    public static String getInputSchema() {
        String schemaVal = GqlSchemaGeneratorUtils.DEFAULT_SCHEMA_START_ELEM;
        GqlSchemaGenerator schemaGenerator = new GqlSchemaQueryGenerator();
        schemaVal += schemaGenerator.generateDefinition("com");

        schemaGenerator = new GqlSchemaModelGenerator();
        schemaVal += schemaGenerator.generateDefinition("com");
        return schemaVal;

    }

    protected static Optional<String> lookupDefaultSupportedType(Class<?> clazz) {
        return Optional.ofNullable(supportedDefaultFieldTypesMapping.get(clazz));
    }

    protected static Optional<String> lookupSupportedTypeOrDefault(Class<?> clazz) {
        return Optional.ofNullable(supportedDefaultFieldTypesMapping.containsKey(clazz) ?
                supportedDefaultFieldTypesMapping.get(clazz) : String.class.getSimpleName());
    }

    protected static Set<BeanDefinition> getBeanDefinitions(final String basePackage,
                                                   final Class<? extends Annotation> annotationFilter) {
        final ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(annotationFilter));
        return provider.findCandidateComponents(basePackage);
    }
}
