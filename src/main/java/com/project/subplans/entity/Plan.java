package com.project.subplans.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "Plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private float discount;


    @JsonIgnoreProperties("plans")
    @ManyToMany
    @JoinTable(name = "Subscriptioned Subjects",
    joinColumns = {
            @JoinColumn(name = "plan_id",referencedColumnName = "id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "subject_id",referencedColumnName = "id")
    }
    )
    private Set<Subject> subjects;

}
