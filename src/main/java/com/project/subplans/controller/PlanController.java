package com.project.subplans.controller;


import com.project.subplans.dto.PlanDTO;
//import com.project.subplans.dto.ResponseDTO;
import com.project.subplans.service.PlanService;
//import com.project.subplans.util.StatusList;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/plan")
@CrossOrigin
public class PlanController {

    @Autowired
    private PlanService planService;

//    @Autowired
//    private ResponseDTO responseDTO;

    @PostMapping(value = "/savePlan")
    public PlanDTO savePlan(@RequestBody PlanDTO planDTO) {
        return planService.savePlan(planDTO);

//        try{
//            String res=planService.savePlan(planDTO);
//
//            if(res.equals("00")){
//                responseDTO.setCode(StatusList.RSP_SUCCESS);
//                responseDTO.setMessage("Success");
//                responseDTO.setContent(planDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//
//            }
//            else if(res.equals("06")){
//                responseDTO.setCode(StatusList.RSP_DUPLICATED);
//                responseDTO.setMessage("Plan already available");
//                responseDTO.setContent(planDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//
//            }
//            else{
//                responseDTO.setCode(StatusList.RSP_FAIL);
//                responseDTO.setMessage("Error");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//        }
//        catch (Exception e){
//            responseDTO.setCode(StatusList.RSP_ERROR);
//            responseDTO.setMessage(e.getMessage());
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//        }

    }

    @GetMapping("/getPlanByPId/{planId}")
    public PlanDTO getPlanByPlanId(@PathVariable String planId) {

        return planService.getPlanByPlanId(planId);

    }

    @PutMapping(value = "/updatePlan")
    public PlanDTO updatePlan(@RequestBody PlanDTO planDTO) {
        return planService.updatePlan(planDTO);
//        try{
//            String resp= planService.updatePlan(planDTO);
//
//            if(resp.equals("00")){
//                responseDTO.setCode(StatusList.RSP_SUCCESS);
//                responseDTO.setMessage("Success");
//                responseDTO.setContent(planDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//
//            }
//            else if(resp.equals("01")){
//                responseDTO.setCode(StatusList.RSP_DUPLICATED);
//                responseDTO.setMessage("Not a registered plan");
//                responseDTO.setContent(planDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//
//            }
//            else{
//                responseDTO.setCode(StatusList.RSP_FAIL);
//                responseDTO.setMessage("Error");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//        }
//        catch (Exception ex){
//            responseDTO.setCode(StatusList.RSP_ERROR);
//            responseDTO.setMessage(ex.getMessage());
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }

    @DeleteMapping("/deletePlan/{planId}")
    public boolean deletePlan(@PathVariable String planId) {
        return planService.deletePlan(planId);
//        try{
//            String res = planService.deletePlan(planId);
//
//            if(res.equals("00")){
//                responseDTO.setCode(StatusList.RSP_SUCCESS);
//                responseDTO.setMessage("Success");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//
//            }
//            else {
//                responseDTO.setCode(StatusList.RSP_NO_DATA_FOUND);
//                responseDTO.setMessage("No plan available for this ID");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//
//        }
//        catch (Exception ex){
//            responseDTO.setCode(StatusList.RSP_ERROR);
//            responseDTO.setMessage(ex.getMessage());
//            responseDTO.setContent(ex);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }


    @GetMapping(value = "/getAllPlans")
    public List<PlanDTO> getAllPlans (){
        return planService.getALlPlans();
//        try{
//            List<PlanDTO> employeeDTOList = planService.getALlPlans();
//            responseDTO.setCode(StatusList.RSP_SUCCESS);
//            responseDTO.setMessage("Success");
//            responseDTO.setContent(employeeDTOList);
//            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//        }
//
//        catch (Exception e){
//            responseDTO.setCode(StatusList.RSP_ERROR);
//            responseDTO.setMessage(e.getMessage());
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }




}
