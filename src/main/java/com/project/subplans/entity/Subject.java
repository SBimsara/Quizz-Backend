package com.project.subplans.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;

import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Table(name = "Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subjectname;
    private String grade;


    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private Set<Lesson> lessons;


    @JsonIgnoreProperties("subjects")
    @ManyToMany(mappedBy = "subjects")
    private Set<Plan> plans ;

    public void addPlan(Plan plan) {
        plans.add(plan);
        plan.getSubjects().add(this);
    }

    public void removePlan(Plan plan) {
        plans.remove(plan);
        plan.getSubjects().remove(this);
    }


}