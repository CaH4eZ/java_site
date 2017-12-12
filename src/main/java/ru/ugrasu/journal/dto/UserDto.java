package ru.ugrasu.journal.dto;

import lombok.Data;
import ru.ugrasu.journal.model.entities.*;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String name;
    private String password;
    private List<SubjectEntity> subjectsById;
    private RoleEntity roleByRole;
    private StudyGroupEntity studyGroupByStudyGroup;
    private DepartmentEntity departmentByDepartment;
    private List<UserExcerciseEntity> userExcercisesById;
}
