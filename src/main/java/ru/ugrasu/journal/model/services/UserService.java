package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.UserEntity;
import ru.ugrasu.journal.model.repositories.UserExcerciseRepository;
import ru.ugrasu.journal.model.repositories.UserRepository;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

}
