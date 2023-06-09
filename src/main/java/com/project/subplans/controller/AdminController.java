package com.project.subplans.controller;

import com.project.subplans.dto.AdminDTO;
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
}