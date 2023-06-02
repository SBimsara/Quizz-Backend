package com.project.subplans.controller;

import com.project.subplans.dto.SubjectDTO;
import com.project.subplans.service.SubjectService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/getSubjects")
    public List<SubjectDTO> getSubject() {
        return subjectService.getAllSubjects();
    }

    @PostMapping("/saveSubject")
    public SubjectDTO saveSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.saveSubject(subjectDTO);
    }
    @PutMapping("/updateSubject")
    public SubjectDTO updateSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.updateSubject(subjectDTO);
    }

    @DeleteMapping("/deleteSubject")
    public boolean deleteSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.deleteSubject(subjectDTO);
    }

    @GetMapping("/getUserBySubjectId/{subjectID}")
    public SubjectDTO getSubjectBySubjectID(@PathVariable String subjectID){
        return subjectService.getSubjectBySubjectID(subjectID);
    }

    @GetMapping("/getUserBySubjectIDAndGrade/{subjectID}/{grade}")
    public SubjectDTO getSubjectBySubjectIDAndGrade(@PathVariable String subjectID ,@PathVariable String grade){
        System.out.println("User ID :"+ subjectID +"User grade :" +grade);
        return subjectService.getSubjectBySubjectIDAndGrade(subjectID,grade);
    }

    @DeleteMapping("/deleteSubjectById/{subId}")
    public boolean deleteSubjectById(@PathVariable String subId) {
        return subjectService.deleteSubjectById(subId);
    }

    

}
