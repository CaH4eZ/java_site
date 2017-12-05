package ru.ugrasu.journal.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ugrasu.journal.model.entities.ExcerciseEntity;

@Repository
public interface ExcerciseRepository extends CrudRepository<ExcerciseEntity, Integer> {

}