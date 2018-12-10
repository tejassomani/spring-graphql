package com.tej.repositories;

import com.tej.models.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository {

    List<Course> getCoursesByInstructor(final int id);
}
