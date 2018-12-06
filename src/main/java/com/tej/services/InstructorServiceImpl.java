package com.tej.services;

import com.base.annotations.GqlSchemaQueryDef;
import com.base.annotations.GqlSchemaQuery;
import com.tej.models.Instructor;
import com.tej.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@GqlSchemaQueryDef
public class InstructorServiceImpl {

    @Autowired
    public InstructorRepository instructorRepository;

    @GqlSchemaQuery("instructors")
    public List<Instructor> getAllInstructors() {
        return new ArrayList<>(instructorRepository.getAllInstructors());
    }

    @GqlSchemaQuery("instructor")
    public Instructor getInstructorById(final int id) {
        return instructorRepository.getInstructor(id);
    }


}
