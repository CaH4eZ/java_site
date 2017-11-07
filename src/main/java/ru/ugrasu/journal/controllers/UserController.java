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

    //TODO Общий список недоработок:
    //1. Закончить структуру БД
    //2. Написать вьюшку SQL для удобства обработки
    //3. Расписать функционал
    //4. Обработка Null-value
    //5. Обработка исключений
    //6. Связи между таблицами
    //7. Замена значений в связях
    //8. Можно возвращать ResponseEntity (вернет так же указанный статус HTTP параметром)
    //9. Frontend нарисовать)
    //10. При редактировании пользователя логичнее сделать выпадающий список

    @RequestMapping(value = "/findById/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public UserEntity findById(@PathVariable("id") int id) {
        System.out.println("Execution: controller - findById - " + id);
        UserEntity userEntity = userService.findById(id);
        if (userEntity == null) {
            throw new ResourceNotFoundException("Teacher not found");
        } else {
            return userEntity;
        }
    }

    @RequestMapping(value = "/findByName/{name}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<UserEntity> findByName(@PathVariable("name") String name) {
        System.out.println("Execution: controller - findByName - " + name);
        try {
            return userService.findByName(name);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Teacher not found");
        }
    }

    @RequestMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, method = RequestMethod.POST)
    public UserEntity save(UserEntity newUser){
        return userService.save(newUser);

        //TODO Response возвращает со статусом
        //return new ResponseEntity<UserEntity>(newUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public void delete (@PathVariable("id") Integer id) {
        System.out.println("Execution: controller - deleteById - " + id);
        UserEntity userEntity = findById(id);
        if (userEntity == null) {
            throw new ResourceNotFoundException("Teacher not found");
        } else {
            userService.deleteById(id);
        }
    }

}