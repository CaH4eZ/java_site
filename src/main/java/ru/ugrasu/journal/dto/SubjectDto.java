package ru.ugrasu.journal.dto;

import java.util.List;

public class SubjectDto {
    private int id;
    private String name;
    private List<ExcerciseDto> excercisesById;
    private UserDto userByTeacher;

}
