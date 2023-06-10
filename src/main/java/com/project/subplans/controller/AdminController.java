package com.project.subplans.controller;

import com.project.subplans.dto.AdminDTO;
import com.project.subplans.dto.LoginDTO;
import com.project.subplans.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO loginDTO) {
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
            String errorMessage = "Invalid username or password";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }



}