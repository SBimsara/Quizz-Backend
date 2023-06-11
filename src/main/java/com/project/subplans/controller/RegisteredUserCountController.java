package com.project.subplans.controller;

import com.project.subplans.dto.RegisteredUserCountDTO;
import com.project.subplans.service.RegisteredUserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/userStat")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisteredUserCountController {

    @Autowired
    RegisteredUserCountService registeredUserCountService;

    //RegisteredUserCount
    @PostMapping(value = "/saveRegUserCount")
    public RegisteredUserCountDTO saveRegUser(@RequestBody RegisteredUserCountDTO registeredUserCountDTO){
        return registeredUserCountService.saveRegUser(registeredUserCountDTO);
    }

    @GetMapping(value = "/getRegUserCount")
    public List<RegisteredUserCountDTO> getRegUserCount(){
        return registeredUserCountService.getRegUserCount();
    }

    @GetMapping("/getRegUserCountbyMonths/{months}")
    public List<RegisteredUserCountDTO> getRegUserCountbyMonths(@PathVariable int months) {

        return registeredUserCountService.getRegUserCountbyMonths(months);

    }
}
