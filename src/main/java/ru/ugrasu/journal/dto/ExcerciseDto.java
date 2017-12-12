package ru.ugrasu.journal.dto;

import java.sql.Date;
import java.util.List;

public class ExcerciseDto {
    private int id;
    private Date date;
    private SubjectDto subjectBySubjectId;
    private List<UserExcerciseDto> userExcercisesById;

}
