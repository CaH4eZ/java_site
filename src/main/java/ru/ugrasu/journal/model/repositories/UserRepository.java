package ru.ugrasu.journal.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ugrasu.journal.model.entities.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    @Query("select u from UserEntity u where u.name like concat(:name,'%')")
    public List<UserEntity> findByName(@Param("name") String name);

    @Query("select u from UserEntity u")
    public List<UserEntity> findAll();
}