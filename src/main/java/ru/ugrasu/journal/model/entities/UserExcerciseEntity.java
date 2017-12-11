package ru.ugrasu.journal.model.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user-excercise", schema = "journal", catalog = "")
public class UserExcerciseEntity {
    @Id@Column(name = "id")
    private int id;
    @ManyToOne@JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    private UserEntity userByUser;
    @ManyToOne@JoinColumn(name = "excercise", referencedColumnName = "id", nullable = false)
    private ExcerciseEntity excerciseByExcercise;

}
