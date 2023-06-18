package com.project.subplans.service;


import com.project.subplans.dto.PlanDTO;
import com.project.subplans.entity.Plan;
import com.project.subplans.entity.SubjectClass;
import com.project.subplans.repo.PlanRepo;
import com.project.subplans.repo.SubjectsRepo;
import com.project.subplans.util.StatusList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PlanService {

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private SubjectsRepo subjectRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String savePlan(PlanDTO planDTO) {

//        planRepo.save(modelMapper.map(planDTO, Plan.class));
//        return StatusList.RSP_SUCCESS;

        if(planRepo.existsById(planDTO.getId())) {
            return StatusList.RSP_DUPLICATED;
        } else if (planRepo.existsByName(planDTO.getName())) {
            return StatusList.RSP_DUPLICATED_NAME;
            
        } else{
            planRepo.save(modelMapper.map(planDTO, Plan.class));
            return StatusList.RSP_SUCCESS;
        }
    }

    public PlanDTO getPlanByPlanId(String planId) {

        Plan plan=planRepo.getPlanById(planId);
        return modelMapper.map(plan,PlanDTO.class);
    }

    public String updatePlan(PlanDTO planDTO) {
//        planRepo.save(modelMapper.map(planDTO, Plan.class));
//        return true;

        if(planRepo.existsById(planDTO.getId())){
            planRepo.save(modelMapper.map(planDTO, Plan.class));
            return StatusList.RSP_SUCCESS;
        }
        else{
            return StatusList.RSP_NO_DATA_FOUND;
        }
    }



    public String deletePlan(int planId){
//        Plan plan = planRepo.getPlanById(planId);
//        planRepo.delete(modelMapper.map(plan,Plan.class));
//        return true;
        if(planRepo.existsById(planId)){
            planRepo.deleteById(planId);
            return StatusList.RSP_SUCCESS;
        }
        else{
            return StatusList.RSP_NO_DATA_FOUND;
        }
    }


    public List<PlanDTO> getALlPlans() {
        List<Plan> planList=planRepo.findAll();
        return  modelMapper.map(planList, new TypeToken<List<PlanDTO>>(){}.getType());
    }


    public boolean addSubjectToPlan (String planId, String subjectId){

        if(planRepo.existsById(Integer.parseInt(planId))){
            Plan plan = planRepo.getPlanById(planId);
            if(subjectRepo.existsById(Long.parseLong(subjectId))){
                SubjectClass subject = subjectRepo.getSubjectBySubjectID(subjectId);

                plan.getSubjects().add(subject);
                planRepo.save(plan);

                return true;
            }
            return false;
        }
        return false;

    }

    public boolean removeSubjectFromPlan (String planId, String subjectId){

        if(planRepo.existsById(Integer.parseInt(planId))){
            Plan plan = planRepo.getPlanById(planId);
            if(subjectRepo.existsById(Long.parseLong(subjectId))){
                SubjectClass subject = subjectRepo.getSubjectBySubjectID(subjectId);

                plan.getSubjects().remove(subject);
                planRepo.save(plan);

                return true;
            }
            return false;
        }
        return false;
    }




}
