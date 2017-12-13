package ru.ugrasu.journal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ugrasu.journal.dto.*;
import ru.ugrasu.journal.model.entities.StudyGroupEntity;
import ru.ugrasu.journal.model.entities.SubjectEntity;
import ru.ugrasu.journal.model.entities.UserEntity;
import ru.ugrasu.journal.model.entities.UserExcerciseEntity;
import ru.ugrasu.journal.model.services.StudyGroupService;
import ru.ugrasu.journal.model.services.SubjectService;
import ru.ugrasu.journal.model.services.UserExcerciseService;
import ru.ugrasu.journal.model.services.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudyGroupService studyGroupService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserExcerciseService userExcerciseService;

    @RequestMapping(value = "/refrashSubject", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<SubjectDto> findAllSubject() {
        System.out.println("TeacherController - findAllSubject");

        List<SubjectDto> listSubjectDto = new ArrayList<>();
        List<SubjectEntity> listSubjectEntity = subjectService.findAll();

        if (listSubjectEntity == null) {
            throw new RuntimeException("No groups");
        }
        else {
            listSubjectEntity.forEach(subjectEntity -> {
                SubjectDto subjectDto = new SubjectDto();
                subjectDto.setId(subjectEntity.getId());
                subjectDto.setName(subjectEntity.getName());

                listSubjectDto.add(subjectDto);
            });

            return listSubjectDto;
        }
    }

    @RequestMapping(value = "/refrashStudyGroup", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<StudyGroupDto> findAllStudyGroup() {
        System.out.println("TeacherController - findAllStudyGroup");

        List<StudyGroupDto> listStudyGroupDto = new ArrayList<>();
        List<StudyGroupEntity> listStudyGroupEntity = studyGroupService.findAll();

        if (listStudyGroupEntity == null) {
            throw new RuntimeException("No groups");
        }
        else {
            listStudyGroupEntity.forEach(studyGroupEntity -> {
                StudyGroupDto studyGroupDto = new StudyGroupDto();
                studyGroupDto.setId(studyGroupEntity.getId());
                studyGroupDto.setName(studyGroupEntity.getName());

                listStudyGroupDto.add(studyGroupDto);
            });

            return listStudyGroupDto;
        }
    }

    @RequestMapping(value = "/getStudentsByGroup/{id}", produces = APPLICATION_JSON_UTF8_VALUE, method = GET)
    public List<UserDto> findUserByGroupId(@PathVariable("id") int id) {
        System.out.println("TeacherController - findUserByGroupId - " + id);

        List<UserDto>       listUserDto = new ArrayList<>();
        List<UserEntity> listUserEntity = userService.findUserByGroupId(id);

        if (listUserEntity == null) {
            throw new RuntimeException("No groups");
        }
        else {
            listUserEntity.forEach(userEntity -> {
                UserDto userDto = new UserDto();
                userDto.setId(userEntity.getId());
                userDto.setName(userEntity.getName());
                userDto.setStudyGroupByStudyGroup(userEntity.getStudyGroupByStudyGroup().getName());

                //Обработка промежуточной таблицы
                List<UserExcerciseEntity> listUserExcerciseEntity = userEntity.getUserExcercisesById();
                List<ExcerciseDto> listExcerciseDto = new ArrayList<>();

                if (listUserExcerciseEntity != null) {

                    listUserExcerciseEntity.forEach(userExcerciseEntity -> {

                        ExcerciseDto excerciseDto = new ExcerciseDto();

                        excerciseDto.setId(userExcerciseEntity.getExcerciseByExcercise().getId());
                        excerciseDto.setDate(userExcerciseEntity.getExcerciseByExcercise().getDate());

                        listExcerciseDto.add(excerciseDto);
                    });
                }

                userDto.setExcercisesById(listExcerciseDto);

                listUserDto.add(userDto);
            });

            if (listUserDto == null) {
                throw new RuntimeException("No students");
            }
            else {
                return listUserDto;
            }
        }
    }
}