package com.project.subplans.controller;

import com.project.subplans.dto.AdminDTO;
import com.project.subplans.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/saveDetails")
    public AdminDTO saveDetails(@RequestBody AdminDTO adminDTO) {
        return adminService.saveDetails(adminDTO);
    }
}