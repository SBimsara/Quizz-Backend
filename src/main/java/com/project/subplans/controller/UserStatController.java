package com.project.subplans.controller;

import com.project.subplans.dto.PlanDTO;
import com.project.subplans.dto.RegisteredUserCountDTO;
import com.project.subplans.dto.UserDTO;
import com.project.subplans.service.UserStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/userStat")
@CrossOrigin(origins = "http://localhost:3000")
public class UserStatController {
    @Autowired
    UserStatService userStatService;

    @GetMapping(value = "/getUser")
    public List<UserDTO> getUser(){
        return userStatService.getAllUsers();
    }

    @GetMapping(value = "/totUserCount")
    public int getUserCount(){
        return userStatService.getUserCount();
    }
    @PostMapping(value = "/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userStatService.saveUser(userDTO);
    }


}
