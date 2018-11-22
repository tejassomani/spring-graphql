package com.tej.services;

import com.tej.models.Class;
import com.tej.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl {

    @Autowired
    public ClassRepository classRepository;

    public List<Class> getClassesByInstructor(final int id) {
        return classRepository.getClassesByInstructor(id);
    }

}
