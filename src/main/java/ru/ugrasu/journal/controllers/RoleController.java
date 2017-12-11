package ru.ugrasu.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ugrasu.journal.dto.RoleDto;
import ru.ugrasu.journal.model.entities.RoleEntity;
import ru.ugrasu.journal.model.services.RoleService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/findAll", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<RoleDto> findAll() {
        System.out.println("RoleController - findAll");

        List<RoleDto> roleDtoList = new ArrayList<>();
        List<RoleEntity> roleEntityList = roleService.findAll();

        if (roleEntityList == null) {
            throw new RuntimeException("No roles? Impossible to see that error");
        }
        else {
            roleEntityList.forEach(roleEntity -> {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(roleEntity.getId());
                roleDto.setName(roleEntity.getName());

                roleDtoList.add(roleDto);
            });

            return roleDtoList;
        }
    }
}
