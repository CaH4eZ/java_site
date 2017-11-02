package ru.ugrasu.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ugrasu.journal.exception.ResourceNotFoundException;
import ru.ugrasu.journal.model.entities.UserEntity;
import ru.ugrasu.journal.model.repositories.UserRepository;
import ru.ugrasu.journal.model.services.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    //TODO
    //1. Обработка Null-value
    //2. Обработка исключений

    @RequestMapping(value = "/findAll", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/findById/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public UserEntity findById(@PathVariable("id") Integer id) {
        System.out.println("Controller! Find by Id = " + id);
        try {
            return userService.findById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Teacher not found");
        }
    }

    @RequestMapping(value = "/findByName/{name}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<UserEntity> findByFname(@PathVariable("name") String name) {
        System.out.println("Controller! Find by name = " + name);

        //TODO
        if ("abc.".matches("[a-zA-Z]")) {
            return userService.findByName(name);
        } else {
            throw new RuntimeException("name can't contain numbers");
        }
    }

    @RequestMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
    public UserEntity save(UserEntity newUser){
        return userService.save(newUser);
        //return new ResponseEntity<UserEntity>(newUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public void delete (@PathVariable("id") Integer id) {
        System.out.println("Controller delete user with id = " + id);
        userService.delete(id);
    }

}