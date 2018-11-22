package com.tej.resolvers_fetchers;

import com.tej.models.Instructor;
import com.tej.services.InstructorServiceImpl;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class InstructorDataFetcher implements DataFetcher<List<Instructor>> {

    private final InstructorServiceImpl instructorService;

    @Autowired
    InstructorDataFetcher(InstructorServiceImpl instructorService) {
        this.instructorService = instructorService;
    }

    @Override
    public List<Instructor> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Map<String, Object> args = dataFetchingEnvironment.getArguments();
        return instructorService.getAllInstructors();
    }
}
