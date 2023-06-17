package com.project.subplans.controller;

import com.project.subplans.entity.Grade;
import com.project.subplans.repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GradeController {

    @Autowired
    private GradeRepo gradeRepo;

    @PostMapping("/grade")
    Grade newGrade(@RequestBody Grade newGrade){
        return gradeRepo.save(newGrade);
    }

    @GetMapping("/grades")
    List<Grade> getAllGrades(){
        return gradeRepo.findAll();
    }
}
