package ru.ugrasu.journal.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ugrasu.journal.model.entities.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

}