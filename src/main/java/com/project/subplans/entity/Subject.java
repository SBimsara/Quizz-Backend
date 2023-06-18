package com.project.subplans.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long id;

    private String subject_name;

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
