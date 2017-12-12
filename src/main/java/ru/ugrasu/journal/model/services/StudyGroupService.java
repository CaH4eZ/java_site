package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.repositories.InstituteRepository;
import ru.ugrasu.journal.model.repositories.StudyGroupRepository;

@Component
public class StudyGroupService {

    @Autowired
    private StudyGroupRepository studyGroupRepository;

}
