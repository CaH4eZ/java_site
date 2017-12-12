package ru.ugrasu.journal.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyGroupRepository extends CrudRepository<StudyGroupRepository, Integer> {
}
