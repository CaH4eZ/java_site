package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.UserExcerciseEntity;
import ru.ugrasu.journal.model.repositories.SubjectRepository;
import ru.ugrasu.journal.model.repositories.UserExcerciseRepository;

import java.util.List;

@Component
public class UserExcerciseService {

    @Autowired
    private UserExcerciseRepository userExcerciseRepository;

    public List<UserExcerciseEntity> findAll() {
        return userExcerciseRepository.findAll();
    }

    public void delete(UserExcerciseEntity userExcerciseEntity) {
        userExcerciseRepository.delete(userExcerciseEntity);
    }
}
