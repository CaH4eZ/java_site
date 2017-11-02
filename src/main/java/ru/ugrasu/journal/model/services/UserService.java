package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.UserEntity;
import ru.ugrasu.journal.model.repositories.UserRepository;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(int id) {
        UserEntity user;
        user = userRepository.findOne(id);
        if (user == null) {
            throw new RuntimeException("User with id = " + id + " not found");
        }
        return user;
    }

    public List<UserEntity> findByName(String name) {
        return userRepository.findByNameContaining(name);
    }

    public void delete(int id) {userRepository.delete(id);}

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

}
