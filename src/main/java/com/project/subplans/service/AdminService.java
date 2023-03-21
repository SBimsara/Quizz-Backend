package com.project.subplans.service;


import com.project.subplans.dto.AdminDTO;
import com.project.subplans.entity.Admin;
import com.project.subplans.repo.AdminRepo;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AdminDTO saveAdmin(AdminDTO adminDTO){
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        return adminDTO;
    }

    public List<AdminDTO> getAllAdmins(){
        List<Admin>adminList=adminRepo.findAll();
        return modelMapper.map(adminList, new TypeToken<List<AdminDTO>>(){}.getType());
    }

    public AdminDTO updateAdmin(AdminDTO adminDTO){
        adminRepo.save(modelMapper.map(adminDTO, Admin.class));
        return adminDTO;
    }

    public boolean deleteAdmin(AdminDTO adminDTO){
        adminRepo.delete(modelMapper.map(adminDTO, Admin.class));
        return true;
    }


    public AdminDTO getAdminByAdminID(String adminId){
        Admin admin= adminRepo.getAdminByAdminID(adminId);
        return modelMapper.map(admin, AdminDTO.class);
    }
}
