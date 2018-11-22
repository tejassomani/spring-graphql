package com.tej.services;

import com.tej.models.Instructor;
import com.tej.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorServiceImpl {

    @Autowired
    public InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return new ArrayList<>(instructorRepository.getAllInstructors());
    }

    public Instructor getInstructorById(final int id) {
        return instructorRepository.getInstructor(id);
    }


}
