package com.project.subplans.service;

import com.project.subplans.dto.PointsDTO;
import com.project.subplans.dto.SummaryDTO;
import com.project.subplans.entity.Points;
import com.project.subplans.entity.Summary;
import com.project.subplans.repo.SummaryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SummaryService {
    @Autowired
    private SummaryRepo summaryRepo;
    @Autowired
    private ModelMapper modelMapper;

    public List<SummaryDTO> getSummary(){
        List<Summary>summaryList=summaryRepo.findAll();
        return modelMapper.map(summaryList, new TypeToken<List<SummaryDTO>>(){}.getType());
    };

    public SummaryDTO saveSummary(SummaryDTO summaryDTO){
        summaryRepo.save(modelMapper.map(summaryDTO, Summary.class));
        return summaryDTO;
    };
}
