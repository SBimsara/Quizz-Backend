package com.project.subplans.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class SubjectClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    private String subject_name;

    public Long getSubject_id() {
        return id;
    }

    public void setSubject_id(Long subject_id) {
        this.id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }
}
