package com.tej.resolvers_fetchers;

import com.tej.models.Class;
import com.tej.models.Instructor;
import com.tej.services.ClassServiceImpl;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassDataFetcher implements DataFetcher<List<Class>> {

    private final ClassServiceImpl classService;

    @Autowired
    ClassDataFetcher(ClassServiceImpl classService) {
        this.classService = classService;
    }

    @Override
    public List<Class> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Instructor instructor = dataFetchingEnvironment.getSource();
        return classService.getClassesByInstructor(instructor.getId());
    }
}
