package com.project.subplans.controller;
import com.project.subplans.entity.Term;
import com.project.subplans.repo.TermRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/term")
@CrossOrigin(origins={"*"})
public class TermController {
    @Autowired
    private TermRepo termRepo;

    @PostMapping("/term")
    Term newTerm(@RequestBody Term newTerm){
        return termRepo.save(newTerm);
    }

    @GetMapping("/terms")
    List<Term> getAllSubjects(){
        return termRepo.findAll();
    }
}
