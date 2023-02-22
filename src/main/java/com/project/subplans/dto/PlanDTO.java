package com.project.subplans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlanDTO {
    private int pid;
    private String name;
    private float price;
    private float discount;

}
