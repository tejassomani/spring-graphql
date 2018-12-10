package com.tej.services;

import com.base.annotations.GqlSchemaQueryDef;
import com.base.annotations.GqlSchemaQuery;
import com.tej.models.Course;
import com.tej.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GqlSchemaQueryDef
public class CourseServiceImpl {

    @Autowired
    public CourseRepository courseRepository;

    //@GqlSchemaQuery
    public List<Course> getClassesByInstructor(final int id) {
        return courseRepository.getCoursesByInstructor(id);
    }

}
