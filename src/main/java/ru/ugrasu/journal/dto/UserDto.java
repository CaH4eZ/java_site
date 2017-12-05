package ru.ugrasu.journal.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private int id;
    private String name;
    private List<SubjectDto> subjectsById;
    private RoleDto roleByRole;
    private StudyGroupDto studyGroupByStudyGroup;
    private DepartmentDto departmentByDepartment;
}
