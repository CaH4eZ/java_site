package ru.ugrasu.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ugrasu.journal.exception.ResourceNotFoundException;
import ru.ugrasu.journal.model.entities.UserEntity;
import ru.ugrasu.journal.model.repositories.UserRepository;
import ru.ugrasu.journal.model.services.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(value = "/deleteById/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public String deleteById(@PathVariable("id") Integer id) {
        try {
            userService.deleteById(id);
            return "Controller! Deleted with id = " + id;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @RequestMapping(value = "/insertIntoDB/{id}/{name}/{role}/{group}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public UserEntity insertIntoDB(@PathVariable("id") int id, @PathVariable("name") String name, @PathVariable("role") int role, @PathVariable("group") int group) {
        userService.insertIntoDB(id,name,role,group);
        return userService.findById(id);
    }

    @RequestMapping(value = "/updateById/{id}/{name}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public UserEntity updateById(@PathVariable("id") int id, @PathVariable("name") String name) {
        UserEntity user;
        user = userService.findById(id);
        if (user == null) {
            throw new RuntimeException("User with id = " + id + " not found");
        }
        userService.updateById(id,name);
        user = new UserEntity();
        user = userService.findById(id);
        return user;
    }
}