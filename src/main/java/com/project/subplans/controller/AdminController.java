package com.project.subplans.controller;

import com.project.subplans.dto.AdminDTO;
import com.project.subplans.dto.LoginDTO;
import com.project.subplans.dto.ResetPasswordDTO;
import com.project.subplans.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "api/v1/admin")
@CrossOrigin
@Validated // Enable validation for the controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/saveDetails")
    public ResponseEntity<Object> saveDetails(@Valid @RequestBody AdminDTO adminDTO) {
        try {
            AdminDTO savedAdminDTO = adminService.saveDetails(adminDTO);
            return ResponseEntity.ok(savedAdminDTO);
        } catch (Exception e) {
            String errorMessage = "Failed to save admin details";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    @PostMapping(value = "/login", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        try {
            AdminDTO adminDTO = adminService.getAdminByUsername(loginDTO.getUsername());

            // Implement authentication logic here (e.g., compare username and password)
            if (adminDTO != null && (adminDTO.getUsername().equals(loginDTO.getUsername()) && adminDTO.getPassword().equals(loginDTO.getPassword()))) {
                // Authentication successful
                String successMessage = "Login successful!";
                return ResponseEntity.ok(successMessage);
            } else {
                // Invalid username or password
                String errorMessage = "Invalid username or password";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Failed to login";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    @GetMapping("/getAdmins")
    public List<AdminDTO> getAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping("/saveAdmin")
    public AdminDTO saveAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.saveAdmin(adminDTO);
    }

    @PutMapping("/updateAdmin")
    public AdminDTO updateAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(adminDTO);
    }

    @DeleteMapping("/deleteAdmin")
    public boolean deleteAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.deleteAdmin(adminDTO);
    }

    @GetMapping("/getAdminByAdminId/{adminId}")
    public AdminDTO getAdminByAdminId(@PathVariable String adminId) {

        return adminService.getAdminByAdminID(adminId);
    }

    @PostMapping(value = "/resetPassword")
    public ResponseEntity<Object> resetPassword(@Valid @RequestBody ResetPasswordDTO resetPasswordDTO) {
        try {
            AdminDTO adminDTO = adminService.getAdminByUsername(resetPasswordDTO.getUsername());

            // Check if admin exists
            if (adminDTO != null) {
                // Check if the new password and confirm new password match
                if (resetPasswordDTO.getNewPassword().equals(resetPasswordDTO.getConfirmNewPassword())) {
                    // Update admin's password
                    adminDTO.setPassword(resetPasswordDTO.getNewPassword());
                    AdminDTO updatedAdminDTO = adminService.updateAdmin(adminDTO);
                    return ResponseEntity.ok(updatedAdminDTO);
                } else {
                    // New password and confirm new password do not match
                    String errorMessage = "New password and confirm new password do not match";
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
                }
            } else {
                // Admin not found
                String errorMessage = "Admin not found";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }
        } catch (NoSuchElementException e) {
            String errorMessage = "Admin not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        } catch (IllegalStateException e) {
            String errorMessage = "Failed to reset password";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } catch (Exception e) {
            String errorMessage = "An unexpected error occurred";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }




}