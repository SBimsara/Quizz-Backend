package com.project.subplans.controller;

import com.project.subplans.entity.Question;
import com.project.subplans.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class QuestionController {
    @Autowired
    private QuestionRepo questionRepo;

    @PostMapping("/question")
    Question newQuestion(@RequestBody Question newQuestion){
        return questionRepo.save(newQuestion);
    }
}
