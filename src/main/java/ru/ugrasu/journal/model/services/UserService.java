package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.repositories.UserExcerciseRepository;
import ru.ugrasu.journal.model.repositories.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

}
