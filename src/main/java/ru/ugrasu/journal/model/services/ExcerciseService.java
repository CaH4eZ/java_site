package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.repositories.DepartmentRepository;
import ru.ugrasu.journal.model.repositories.ExcerciseRepository;

@Component
public class ExcerciseService {

    @Autowired
    private ExcerciseRepository excerciseRepository;

}
