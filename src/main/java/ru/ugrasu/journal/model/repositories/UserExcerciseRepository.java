package ru.ugrasu.journal.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserExcerciseRepository extends CrudRepository<UserExcerciseRepository, Integer> {
}
