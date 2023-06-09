package com.project.subplans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.sql.Date;

/*

 A Data Transfer Object class for Admin entity.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    // fields of the AdminDTO
    @Min(value = 1, message = "ID must be positive")
    private int id;

    @NotNull(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Pattern(regexp = "[a-zA-Z]+", message = "First name should contain only alphabetic letters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(max = 50, message = "Last name cannot exceed 30 characters")
    @Pattern(regexp = "[a-zA-Z]+", message = "Last name should contain only alphabetic letters")
    private String lastName;

    @NotNull(message = "Gender is required")
    private String gender;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be valid")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of birth must be in the YYYY-MM-DD format")
    private Date dateOfBirth;

    @NotNull(message = "NIC is required")
    @Pattern(regexp = "[0-9]{9}[vVxX]", message = "NIC format is invalid")
    @Pattern(regexp = "^\\d{9}[Vv]|\\d{12}$", message = "NIC should contain 9 digits and a 'v' or 'V' or 12 digits")
    private String nic;

    @NotNull(message = "Contact number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Please enter a valid phone number")
    private String  contactNumber;

    @NotNull(message = "Email is required")
    @Size(min = 5, max = 50, message = "Email address must be between 5 and 50 characters")
    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull(message = "Username is required")
    @Size(min = 4, max = 20, message = "Username must be between 6 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]{4,20}$", message = "Username may only contain letters, numbers, and underscores")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$", message = "Password must contain at least  one lowercase letter, one uppercase letter, one number and one special character (e.g. !, @, #, $, %, etc.)")
    private String password;

    private boolean isMainAdmin;
}
