package com.tej.repositories.impl;

import com.tej.DummyDataLoader;
import com.tej.models.Class;
import com.tej.repositories.ClassRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassRepositoryImpl implements ClassRepository {

    @Override
    public List<Class> getClassesByInstructor(int id) {
        return DummyDataLoader.getInstructors().get(id).getaClasses();
    }
}
