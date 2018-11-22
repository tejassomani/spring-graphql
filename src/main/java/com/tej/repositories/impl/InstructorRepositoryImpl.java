package com.tej.repositories.impl;

import com.tej.DummyDataLoader;
import com.tej.models.Instructor;
import com.tej.repositories.InstructorRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository {

    @Override
    public Instructor getInstructor(int id) {
        return DummyDataLoader.getInstructors().get(id);
    }

    @Override
    public Collection<Instructor> getAllInstructors() {
        return DummyDataLoader.getInstructors().values();
    }
}
