package ru.ugrasu.journal.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ugrasu.journal.model.entities.RoleEntity;

import java.util.List;


@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

    @Query("select r from RoleEntity r")
    public List<RoleEntity> findAll();

}