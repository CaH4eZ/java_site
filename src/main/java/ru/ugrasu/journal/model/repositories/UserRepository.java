package ru.ugrasu.journal.model.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.ugrasu.journal.model.entities.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    //CRUD: Create, Read, Update, Delete

    @Query("select u from UserEntity u")
    public List<UserEntity> findAll();

    @Query("select u from UserEntity u where u.name like concat(:name,'%')")
    public List<UserEntity> findByNameContaining(@Param("name") String name);

    //TODO обычный метод save не работает, потому что ругается на sql из-за неакранированных кавычек при приеме json'а

    @Transactional
    @Modifying
    @Query(value = "update journal.user u set u.name=:name, u.role=:role, u.group=:group where u.id=:id",
            nativeQuery = true)
    public void mySave(@Param("id") Integer id, @Param("name") String name,
                       @Param("role") Integer role, @Param("group") Integer group);

}