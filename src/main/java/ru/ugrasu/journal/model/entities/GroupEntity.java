package ru.ugrasu.journal.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "group", schema = "journal", catalog = "")
public class GroupEntity {
    private int id;
    private String group;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
