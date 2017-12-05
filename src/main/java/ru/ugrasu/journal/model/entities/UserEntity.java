package ru.ugrasu.journal.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user", schema = "journal", catalog = "")
public class UserEntity {
    @Id@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic@Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "userByUserId")
    private List<SubjectEntity> subjectsById;
    @ManyToOne@JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    private RoleEntity roleByRole;
    @ManyToOne@JoinColumn(name = "study_group", referencedColumnName = "id")
    private StudyGroupEntity studyGroupByStudyGroup;
    @ManyToOne@JoinColumn(name = "department", referencedColumnName = "id")
    private DepartmentEntity departmentByDepartment;

}
