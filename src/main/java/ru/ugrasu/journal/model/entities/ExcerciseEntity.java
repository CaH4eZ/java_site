package ru.ugrasu.journal.model.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "excercise", schema = "journal", catalog = "")
public class ExcerciseEntity {
    @Id@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic@Column(name = "date")
    private Date date;
    @ManyToOne@JoinColumn(name = "study_group_id", referencedColumnName = "id", nullable = false)
    private StudyGroupEntity studyGroupByStudyGroupId;
    @ManyToOne@JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false)
    private SubjectEntity subjectBySubjectId;

}
