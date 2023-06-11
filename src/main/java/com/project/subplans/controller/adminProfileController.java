package com.project.subplans.controller;

import com.project.subplans.dto.AdminDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/admin")
@CrossOrigin

public class adminProfileController {
    @Autowired
    com.project.subplans.service.AdminService adminService;

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
}