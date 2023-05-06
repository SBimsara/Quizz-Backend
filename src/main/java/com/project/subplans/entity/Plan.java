package com.project.subplans.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
