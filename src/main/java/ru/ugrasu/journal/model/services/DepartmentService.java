package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.DepartmentEntity;
import ru.ugrasu.journal.model.entities.RoleEntity;
import ru.ugrasu.journal.model.repositories.DepartmentRepository;
import ru.ugrasu.journal.model.repositories.RoleRepository;

import java.util.List;

@Component
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity findById(int id) {
        return departmentRepository.findOne(id);
    }

}
