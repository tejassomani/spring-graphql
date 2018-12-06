package com.base.process;

import com.base.annotations.GqlSchemaField;
import com.base.annotations.GqlSchemaTypeDef;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.Field;

public class GqlSchemaGenerator {

    public static String generateTypes() {

        final ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(GqlSchemaTypeDef.class));
        for (final BeanDefinition beanDef : provider.findCandidateComponents("com")) {
            System.out.println(beanDef.getBeanClassName());
            getSchemaFields(beanDef);
        }
        return null;
    }

    private static String getSchemaFields(final BeanDefinition beanDefinition) {
        try {
            Class<?> cl = Class.forName(beanDefinition.getBeanClassName());
            for (Field field : cl.getDeclaredFields()) {
                if (field.isAnnotationPresent(GqlSchemaField.class)) {
                    System.out.println(field.getName() + " and type name " + field.getType().getTypeName() +
                    " type " + field.getType().getSimpleName());
                }
            }
        }
        catch (ClassNotFoundException ce) {
            ce.printStackTrace();

        }
        return null;
    }


//   private static String formatTypeString(final Field field) {
//        switch (field.getType().isAssignableFrom()) {
//
//        }
//   }
}
