package ru.ugrasu.journal.dto;

import java.util.List;

public class DepartmentDto {
    private int id;
    private String name;
    private InstituteDto instituteByInstituteId;
    private List<StudyGroupDto> studyGroupsById;
    private List<UserDto> usersById;
}
