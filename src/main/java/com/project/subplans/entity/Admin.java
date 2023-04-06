// This class represents the entity for Admin, which will be mapped to a database table named "Admins".
// It contains fields for storing various information about an Admin.
package com.project.subplans.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Admins")
public class Admin {
    // The id field represents the unique identifier for each Admin, which will be generated automatically.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // The firstName field represents the first name of an Admin.
    private String firstName;

    // The lastName field represents the last name of an Admin.
    private String lastName;

    // The gender field represents the gender of an Admin.
    private String gender;

    // The dateOfBirth field represents the date of birth of an Admin.
    private Date dateOfBirth;

    // The nic field represents the national identification number of an Admin.
    private String nic;

    // The contactNumber field represents the contact number of an Admin.
    private String contactNumber;

    // The email field represents the email address of an Admin.
    private String email;

    // The username field represents the login username of an Admin.
    private String username;

    // The password field represents the login password of an Admin.
    private String password;

    // The isMainAdmin field represents whether an Admin is the main administrator or not.
    private boolean isMainAdmin;



}
