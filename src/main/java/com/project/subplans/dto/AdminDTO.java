package com.project.subplans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/*

 A Data Transfer Object class for Admin entity.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    // fields of the AdminDTO
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String nic;
    private String  contactNumber;
    private String email;
    private String username;
    private String password;
    private boolean isMainAdmin;
}
