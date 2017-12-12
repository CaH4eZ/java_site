package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.repositories.StudyGroupRepository;
import ru.ugrasu.journal.model.repositories.SubjectRepository;

@Component
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

}
