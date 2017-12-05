package ru.ugrasu.journal.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ugrasu.journal.model.entities.DepartmentEntity;
import ru.ugrasu.journal.model.repositories.DepartmentRepository;

@Component
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentEntity save(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity findById(int id) {
        return departmentRepository.findOne(id);
    }

    public void deleteById(int id) { departmentRepository.delete(id); }

}