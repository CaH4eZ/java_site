package ru.ugrasu.journal.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ugrasu.journal.model.entities.StudyGroupEntity;

@Repository
public interface StudyGroupRepository extends CrudRepository<StudyGroupEntity, Integer> {
}
