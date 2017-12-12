package ru.ugrasu.journal.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ugrasu.journal.model.entities.UserExcerciseEntity;

@Repository
public interface UserExcerciseRepository extends CrudRepository<UserExcerciseEntity, Integer> {
}
