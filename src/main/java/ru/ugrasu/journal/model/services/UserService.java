package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.exception.ResourceNotFoundException;
import ru.ugrasu.journal.model.entities.UserEntity;
import ru.ugrasu.journal.model.repositories.UserRepository;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public UserEntity findById(int id) {
        UserEntity userEntity = userRepository.findOne(id);
        if (userEntity == null) {
            throw new ResourceNotFoundException("Teacher not found");
        } else {
            return userEntity;
        }
    }

    public void deleteById(int id) { userRepository.delete(id); }

    public List<UserEntity> findByName(String name) { return userRepository.findByName(name); }

}
