package com.project.subplans.service;


import com.project.subplans.dto.PlanDTO;
import com.project.subplans.entity.Plan;
import com.project.subplans.repo.PlanRepo;
import com.project.subplans.util.StatusList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlanService {

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String savePlan(PlanDTO planDTO) {
        if(planRepo.existsById(planDTO.getPid())) {
            return StatusList.RSP_DUPLICATED;
        }
        else{
            planRepo.save(modelMapper.map(planDTO, Plan.class));
            return StatusList.RSP_SUCCESS;
        }
    }

    public PlanDTO getPlanByPlanId(String planId) {
        Plan plan=planRepo.getPlanById(planId);
        return modelMapper.map(plan,PlanDTO.class);
    }

    public String updatePlan(PlanDTO planDTO) {
        if(planRepo.existsById(planDTO.getPid())){
            planRepo.save(modelMapper.map(planDTO, Plan.class));
            return StatusList.RSP_SUCCESS;
        }
        else{
            return StatusList.RSP_NO_DATA_FOUND;
        }
    }

    public String deletePlan(int planId){
        if(planRepo.existsById(planId)){
            planRepo.deleteById(planId);
            return StatusList.RSP_SUCCESS;
        }
        else{
            return StatusList.RSP_NO_DATA_FOUND;
        }
    }

    public List<PlanDTO> getALlPlans() {
        List<Plan> employeeList=planRepo.findAll();
        return  modelMapper.map(employeeList, new TypeToken<ArrayList<PlanDTO>>(){
        }.getType());
    }






}
