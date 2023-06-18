package com.project.subplans.controller;

import com.project.subplans.entity.QuizType;
import com.project.subplans.repo.QuizTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class QuizTypeController {
    @Autowired
    private QuizTypeRepo quizTypeRepo;

    @PostMapping("/quiztype")
    QuizType newQuizType(@RequestBody QuizType newQuizType){
        return quizTypeRepo.save(newQuizType);
    }

    @GetMapping("/quiztypes")
    List<QuizType> getAllQuizTypes(){
        return quizTypeRepo.findAll();
    }
}
