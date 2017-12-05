package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.StudyGroupEntity;
import ru.ugrasu.journal.model.repositories.StudyGroupRepository;

@Component
public class StudyGroupService {

    @Autowired
    private StudyGroupRepository studyGroupRepository;

    public StudyGroupEntity save(StudyGroupEntity studyGroupEntity) {
        return studyGroupRepository.save(studyGroupEntity);
    }

    public StudyGroupEntity findById(int id) {
        return studyGroupRepository.findOne(id);
    }

    public void deleteById(int id) { studyGroupRepository.delete(id); }

}