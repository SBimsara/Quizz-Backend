package com.project.subplans.service;

import com.project.subplans.dto.PointsDTO;
import com.project.subplans.dto.SubscriptionDTO;
import com.project.subplans.entity.Points;
import com.project.subplans.entity.Subscription;
import com.project.subplans.repo.PointsRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PointsService {
    @Autowired
    private PointsRepo pointsRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<PointsDTO> getPoints(){
        List<Points>pointsList=pointsRepo.findAll();
        return modelMapper.map(pointsList, new TypeToken<List<PointsDTO>>(){}.getType());
    }

    public PointsDTO savePoints(PointsDTO pointsDTO){
        pointsRepo.save(modelMapper.map(pointsDTO, Points.class));
        return pointsDTO;
    }
}
