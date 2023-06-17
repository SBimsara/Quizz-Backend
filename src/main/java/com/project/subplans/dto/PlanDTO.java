package com.project.subplans.dto;

import com.project.subplans.entity.Subject;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanDTO {
    private int id;
    private String name;
    private float price;
    private float discount;
    private Set<Subject> subjects;


}
