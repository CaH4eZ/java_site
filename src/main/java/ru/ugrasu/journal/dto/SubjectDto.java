package ru.ugrasu.journal.dto;

import lombok.Data;

@Data
public class SubjectDto {
    private int id;
    private String name;
    private UserDto userByUserId;
}
