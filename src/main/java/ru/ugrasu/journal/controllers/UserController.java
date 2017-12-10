package ru.ugrasu.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ugrasu.journal.dto.RoleDto;
import ru.ugrasu.journal.dto.UserDto;
import ru.ugrasu.journal.exception.ResourceNotFoundException;
import ru.ugrasu.journal.model.entities.RoleEntity;
import ru.ugrasu.journal.model.entities.UserEntity;
import ru.ugrasu.journal.model.services.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findById/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public UserDto findById(@PathVariable("id") int id) {
        System.out.println("UserController: findById - " + id);
        UserEntity userEntity = userService.findById(id);

        if (userEntity == null) {
            throw new ResourceNotFoundException("Teacher not found");
        } else {
            UserDto userDto = new UserDto();
            userDto.setId(userEntity.getId());
            userDto.setName(userEntity.getName());

            RoleEntity roleEntity = userEntity.getRoleByRole();
            RoleDto roleDto = new RoleDto();
            roleDto.setId(roleEntity.getId());
            roleDto.setName(roleEntity.getName());

            userDto.setRoleByRole(roleDto);

            //TODO
            //Вызвать предметы пользователя
//            userEntity.getSubjectsById().forEach(subjectEntity -> {
//
//            });

            return userDto;

        }
    }

//    @RequestMapping(value = "/findByName/{name}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
//    public List<UserEntity> findByName(@PathVariable("name") String name) {
//        System.out.println("UserController: findByName - " + name);
//        try {
//            return userService.findByName(name);
//        } catch (Exception e) {
//            throw new ResourceNotFoundException("Teacher not found");
//        }
//    }
//
//    @RequestMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
//    public UserEntity save(UserEntity newUser){
//        System.out.println("UserController: save ");
//        return userService.save(newUser);
//
//        //TODO Response возвращает со статусом
//        //return new ResponseEntity<UserEntity>(newUser, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/deleteById/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
//    public void delete (@PathVariable("id") Integer id) {
//        System.out.println("UserController: deleteById - " + id);
//        UserEntity userEntity = findById(id);
//        if (userEntity == null) {
//            throw new ResourceNotFoundException("Teacher not found");
//        } else {
//            userService.deleteById(id);
//        }
//    }
}