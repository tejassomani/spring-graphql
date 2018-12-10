package com.tej.repositories.impl;

import com.tej.DummyDataLoader;
import com.tej.models.Course;
import com.tej.repositories.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Override
    public List<Course> getCoursesByInstructor(int id) {
        return DummyDataLoader.getInstructors().get(id).getCourses();
    }
}
