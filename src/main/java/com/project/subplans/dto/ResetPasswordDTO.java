package com.project.subplans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResetPasswordDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotBlank(message = "New password is required")
    @Size(min = 8, message = "New password must be at least 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$", message = "Password must contain at least  one lowercase letter, one uppercase letter, one number and one special character (e.g. !, @, #, $, %, etc.)")
    private String newPassword;

    @NotBlank(message = "Confirm new password is required")
    @Size(min = 8, message = "Confirm new password must be at least 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$", message = "Password must contain at least  one lowercase letter, one uppercase letter, one number and one special character (e.g. !, @, #, $, %, etc.)")
    private String confirmNewPassword;
}
