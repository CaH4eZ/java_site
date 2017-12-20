package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.ExcerciseEntity;
import ru.ugrasu.journal.model.repositories.DepartmentRepository;
import ru.ugrasu.journal.model.repositories.ExcerciseRepository;

import java.util.List;

@Component
public class ExcerciseService {

    @Autowired
    private ExcerciseRepository excerciseRepository;

    public List<ExcerciseEntity> findAll() {
        return excerciseRepository.findAll();
    }

    public void delete(ExcerciseEntity excerciseEntity) {
        excerciseRepository.delete(excerciseEntity);
    }

    public void save(ExcerciseEntity excerciseEntity) {
        excerciseRepository.save(excerciseEntity);
    }

    public ExcerciseEntity findById(int id) {
        return excerciseRepository.findOne(id);
    }

}
