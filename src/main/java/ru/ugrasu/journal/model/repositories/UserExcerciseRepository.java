package ru.ugrasu.journal.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ugrasu.journal.model.entities.UserExcerciseEntity;

import java.util.List;

@Repository
public interface UserExcerciseRepository extends CrudRepository<UserExcerciseEntity, Integer> {

        @Query("select ue from UserExcerciseEntity ue")
        public List<UserExcerciseEntity> findAll();

}
