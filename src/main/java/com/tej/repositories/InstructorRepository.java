package com.tej.repositories;

import com.tej.models.Instructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InstructorRepository {

    Instructor getInstructor(final int id);

    Collection<Instructor> getAllInstructors();
}
