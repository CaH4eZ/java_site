package ru.ugrasu.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ugrasu.journal.dto.RoleDto;
import ru.ugrasu.journal.dto.UserDto;
import ru.ugrasu.journal.model.entities.RoleEntity;
import ru.ugrasu.journal.model.services.RoleService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/refrash", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<RoleDto> findAll() {
        System.out.println("RoleController - findAll");

        List<RoleDto> listRoleDto = new ArrayList<>();
        List<RoleEntity> listRoleEntity = roleService.findAll();

        if (listRoleEntity == null) {
            throw new RuntimeException("No roles? Impossible to see that error");
        }
        else {
            listRoleEntity.forEach(roleEntity -> {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(roleEntity.getId());
                roleDto.setName(roleEntity.getName());

                List<UserDto> listUserDto = new ArrayList<>();

                roleEntity.getUsersById().forEach(userEntity -> {
                    UserDto userDto = new UserDto();
                    userDto.setId(userEntity.getId());
                    userDto.setName(userEntity.getName());

                    listUserDto.add(userDto);

                });

                roleDto.setUsersById(listUserDto);
                listRoleDto.add(roleDto);
            });

            return listRoleDto;
        }
    }
}