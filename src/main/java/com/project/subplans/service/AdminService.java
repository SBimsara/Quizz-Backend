/*

 Service class for managing Admin entity
 */
package com.project.subplans.service;

import com.project.subplans.dto.AdminDTO;
import com.project.subplans.entity.Admin;
import com.project.subplans.repo.AdminRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Service
@Transactional // Defines the scope of a single database transaction, that is, all the operations inside this service method will be performed as a single transaction
public class AdminService {
    @Autowired // Used for automatic dependency injection of the AdminRepo object
    private AdminRepo adminRepo;

    @Autowired // Used for automatic dependency injection of the ModelMapper object
    private ModelMapper modelMapper;

    /*

     Saves the details of the admin by mapping the AdminDTO object to the Admin entity and
     persisting the latter using the adminRepo object.
     @param adminDTO The AdminDTO object containing the details of the admin to be saved
     @return The saved AdminDTO object
     */

    public AdminDTO saveDetails(@Valid AdminDTO adminDTO) {
        try {
            // Check if the username is already taken
            if (adminRepo.existsByUsername(adminDTO.getUsername())) {
                throw new IllegalArgumentException("Username is already taken");
            }

            // Check if the NIC is already registered
            if (adminRepo.existsByNic(adminDTO.getNic())) {
                throw new IllegalArgumentException("NIC is already registered");
            }

            // Check if the email is already used
            if (adminRepo.existsByEmail(adminDTO.getEmail())) {
                throw new IllegalArgumentException("Email is already used");
            }

            // Check if the contact number is already used
            if (adminRepo.existsByContactNumber(adminDTO.getContactNumber())){
                throw new IllegalArgumentException("Contact number is already used");
            }

            // Map the AdminDTO to the Admin entity
            Admin admin = modelMapper.map(adminDTO, Admin.class);

            // Save the admin entity
            adminRepo.save(admin);

            // Map the saved Admin entity back to AdminDTO
            return modelMapper.map(admin, AdminDTO.class);
        } catch (DataAccessException e) {
            // Handle the exception
            // Log the error or perform any necessary error handling
            throw new IllegalStateException("Failed to save admin details", e);
        }
    }
    public AdminDTO getAdminByUsername(String username) {
        try {
            Admin admin = adminRepo.findByUsername(username);
            if (admin == null) {
                throw new NoSuchElementException("Admin not found");
            }
            return modelMapper.map(admin, AdminDTO.class);
        } catch (DataAccessException e) {
            throw new IllegalStateException("Failed to get admin by username", e);
        }
    }


}








