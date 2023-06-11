package com.project.subplans.service;

import com.project.subplans.dto.RegisteredUserCountDTO;
import com.project.subplans.entity.RegisteredUserCount;
import com.project.subplans.repo.RegisteredUserCountRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class RegisteredUserCountService {
    @Autowired
    private RegisteredUserCountRepo registeredUserCountRepo;

    @Autowired
    private ModelMapper modelMapper;
    //REGISTERED USER COUNT
    public RegisteredUserCountDTO saveRegUser(RegisteredUserCountDTO registeredUserCountDTO) {
        registeredUserCountRepo.save(modelMapper.map(registeredUserCountDTO, RegisteredUserCount.class));
        return registeredUserCountDTO;
    }

    public List<RegisteredUserCountDTO> getRegUserCount() {
        List<RegisteredUserCount>registeredUserCountList=registeredUserCountRepo.findAll();
        return modelMapper.map(registeredUserCountList,new TypeToken<List<RegisteredUserCountDTO>>(){}.getType());
    }

    public List<RegisteredUserCountDTO> getRegUserCountbyMonths(int months){
        List<RegisteredUserCount>registeredUserCountList=registeredUserCountRepo.getRegisteredUserCountbyMonths(months);
        return modelMapper.map(registeredUserCountList,new TypeToken<List<RegisteredUserCountDTO>>(){}.getType());
    }
}
