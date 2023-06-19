package com.project.subplans.controller;

import com.project.subplans.entity.Question;
import com.project.subplans.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/ques")
@CrossOrigin(origins={"*"})
public class QuestionController {
    @Autowired
    private QuestionRepo questionRepo;

    @PostMapping("/question")
    Question newQuestion(@RequestBody Question newQuestion){
        return questionRepo.save(newQuestion);
    }
}
