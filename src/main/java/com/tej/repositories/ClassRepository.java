package com.tej.repositories;

import com.tej.models.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository {

    List<Class> getClassesByInstructor(final int id);
}
