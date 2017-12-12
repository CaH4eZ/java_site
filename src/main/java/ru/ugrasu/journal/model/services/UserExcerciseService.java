package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.repositories.SubjectRepository;
import ru.ugrasu.journal.model.repositories.UserExcerciseRepository;

@Component
public class UserExcerciseService {

    @Autowired
    private UserExcerciseRepository userExcerciseRepository;

}
