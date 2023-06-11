package com.project.subplans.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AdminDTO {
    @Id
    private int id;
    private String firstname;
    private String  lastname;
    private String  mobilenum;
    private String  email;
    private String ide;
}
