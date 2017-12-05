package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.InstituteEntity;
import ru.ugrasu.journal.model.repositories.InstituteRepository;

@Component
public class InstituteService {

    @Autowired
    private InstituteRepository instituteRepository;

    public InstituteEntity save(InstituteEntity instituteEntity) {
        return instituteRepository.save(instituteEntity);
    }

    public InstituteEntity findById(int id) {
        return instituteRepository.findOne(id);
    }

    public void deleteById(int id) { instituteRepository.delete(id); }

}