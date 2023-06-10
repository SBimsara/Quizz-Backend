package com.project.subplans.controller;


import com.project.subplans.dto.PlanDTO;
import com.project.subplans.dto.ResponseDTO;
import com.project.subplans.service.PlanService;
import com.project.subplans.util.StatusList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/plan")
@CrossOrigin(origins={"http://localhost:3000","http://192.168.1.4:19000"})
public class PlanController {

    @Autowired
    private PlanService planService;

    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/savePlan")
    public ResponseEntity savePlan(@RequestBody PlanDTO planDTO) {
//           return planService.savePlan(planDTO);

        try{
            String res=planService.savePlan(planDTO);

            if(res.equals("00")){
                responseDTO.setCode(StatusList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(planDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }
            else if(res.equals("06")){
                responseDTO.setCode(StatusList.RSP_DUPLICATED);
                responseDTO.setMessage("Plan already available");
                responseDTO.setContent(planDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
            else{
                responseDTO.setCode(StatusList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            responseDTO.setCode(StatusList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getPlanById/{planId}")
    public ResponseEntity getPlanByPlanId(@PathVariable String planId) {

//        return planService.getPlanByPlanId(planId);

        try{
            PlanDTO resp=planService.getPlanByPlanId(planId);
            responseDTO.setCode(StatusList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(resp);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            responseDTO.setCode(StatusList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/updatePlan")
    public ResponseEntity updatePlan(@RequestBody PlanDTO planDTO) {
//        return planService.updatePlan(planDTO);
        try{
            String resp= planService.updatePlan(planDTO);

            if(resp.equals("00")){
                responseDTO.setCode(StatusList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(planDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }
            else if(resp.equals("01")){
                responseDTO.setCode(StatusList.RSP_DUPLICATED);
                responseDTO.setMessage("Not a registered plan");
                responseDTO.setContent(planDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);

            }
            else{
                responseDTO.setCode(StatusList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception ex){
            responseDTO.setCode(StatusList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePlan/{planId}")
    public ResponseEntity deletePlan(@PathVariable int planId) {
//        return planService.deletePlan(planId);
        try{
            String res = planService.deletePlan(planId);

            if(res.equals("00")){
                responseDTO.setCode(StatusList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            }
            else {
                responseDTO.setCode(StatusList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No plan available for this ID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }

        }
        catch (Exception ex){
            responseDTO.setCode(StatusList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(ex);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(value = "/getAllPlans")
    public ResponseEntity getAllPlans (){
//        return planService.getALlPlans();
        try{
            List<PlanDTO> planDTOList = planService.getALlPlans();
            responseDTO.setCode(StatusList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(planDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }

        catch (Exception e){
            responseDTO.setCode(StatusList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "addSubject/plans/{planId}/subjects/{subjectId}")
    public boolean addSubjectToPlan(@PathVariable String planId,@PathVariable String subjectId){
        return planService.addSubjectToPlan(planId,subjectId);


    }

    @DeleteMapping(value = "removeSubject/plans/{planId}/subjects/{subjectId}")
    public boolean removeSubjectFromPlan(@PathVariable String planId,@PathVariable String subjectId){
        return planService.removeSubjectFromPlan(planId,subjectId);

    }



}
