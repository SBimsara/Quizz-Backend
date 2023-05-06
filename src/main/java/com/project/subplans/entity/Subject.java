package com.project.subplans.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(mappedBy = "subjects",fetch = FetchType.LAZY)
    private Set<Plan> plans;



}