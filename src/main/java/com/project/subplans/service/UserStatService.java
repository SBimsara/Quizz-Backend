package com.project.subplans.service;

import com.project.subplans.dto.UserDTO;
import com.project.subplans.entity.Plan;
import com.project.subplans.entity.User;
import com.project.subplans.repo.UserStatRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserStatService {
    @Autowired
    private UserStatRepo userStatRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO){
        userStatRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public List<UserDTO> getAllUsers(){
        List<User>userList=userStatRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }

    public int getUserCount(){
        int UC = userStatRepo.getUserCount();
        return UC;
    }
}
