package com.project.subplans.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "plan_id")
    private Long id;

    private String name;
    private Float price;
    private Float discount;

    @JsonIgnoreProperties("plans")
    @ManyToMany
    @JoinTable(name = "Subscriptioned Subjects",
    joinColumns = {
            @JoinColumn(name = "plan_id",referencedColumnName = "plan_id")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "subject_id",referencedColumnName = "subject_id")
    }
    )
    private Set<Subject> subjects;
}
