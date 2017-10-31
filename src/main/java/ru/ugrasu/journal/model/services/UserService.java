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

    public void deleteById(int id) {
        UserEntity user;
        user = userRepository.findOne(id);
        if (user == null) {
            throw new RuntimeException("User with id = " + id + " not found");
        }
            userRepository.deleteById(id);
    }

    public void updateById(int id, String name) {
        UserEntity user;
        user = userRepository.findOne(id);
        if (user == null) {
            throw new RuntimeException("User with id = " + id + " not found");
        }
        userRepository.updateById(id, name);
        //userRepository.save()

        user = userRepository.findOne(id);
        System.out.println("Updated " + id + " user");
    }

    public void insertIntoDB(int id, String name, int role, int group) {
        userRepository.insertIntoDB(id,name,role,group);
    }
}
