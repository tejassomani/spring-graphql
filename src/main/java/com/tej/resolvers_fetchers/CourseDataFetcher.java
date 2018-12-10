package com.tej.resolvers_fetchers;

import com.tej.models.Course;
import com.tej.models.Instructor;
import com.tej.services.CourseServiceImpl;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDataFetcher implements DataFetcher<List<Course>> {

    private final CourseServiceImpl courseService;

    @Autowired
    CourseDataFetcher(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @Override
    public List<Course> get(DataFetchingEnvironment dataFetchingEnvironment) {
        Instructor instructor = dataFetchingEnvironment.getSource();
        return courseService.getClassesByInstructor(instructor.getId());
    }
}
