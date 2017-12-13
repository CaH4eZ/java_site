package ru.ugrasu.journal.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Data
public class ExcerciseDto {
    private int id;
    private Date date;
    private int groupId;
    private SubjectDto subjectBySubjectId;
    private List<UserExcerciseDto> userExcercisesById;

}
