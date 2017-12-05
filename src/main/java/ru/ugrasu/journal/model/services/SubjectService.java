package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.SubjectEntity;
import ru.ugrasu.journal.model.repositories.SubjectRepository;

@Component
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectEntity save(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    public SubjectEntity findById(int id) {
        return subjectRepository.findOne(id);
    }

    public void deleteById(int id) { subjectRepository.delete(id); }

}