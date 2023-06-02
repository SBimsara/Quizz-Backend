package com.project.subplans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lesson {
    @Id
    private int id;
    private String lessonName;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;


}