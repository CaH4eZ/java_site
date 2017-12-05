package ru.ugrasu.journal.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {
    private int id;
    private String name;
    private List<StudyGroupDto> studyGroupsById;
    private List<UserDto> usersById;
}
