package ru.ugrasu.journal.dto;

import java.util.List;

public class StudyGroupDto {
    private int id;
    private String name;
    private DepartmentDto departmentByDepartmentId;
    private List<UserDto> usersById;

}
