package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.ExcerciseEntity;
import ru.ugrasu.journal.model.repositories.ExcerciseRepository;

@Component
public class ExcerciseService {

    @Autowired
    private ExcerciseRepository excerciseRepository;

    public ExcerciseEntity save(ExcerciseEntity excerciseEntity) {
        return excerciseRepository.save(excerciseEntity);
    }

    public ExcerciseEntity findById(int id) {
        return excerciseRepository.findOne(id);
    }

    public void deleteById(int id) { excerciseRepository.delete(id); }

}