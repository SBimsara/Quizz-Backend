package com.project.subplans.dto;

import com.project.subplans.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanDTO {
    private int id;
    private String name;
    private float price;
    private float discount;
    private Set<Subject> subjects;


}
