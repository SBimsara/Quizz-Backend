package com.project.subplans.controller;

import com.project.subplans.entity.SubjectClass;
import com.project.subplans.repo.SubjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SubjectsController {
    @Autowired
    private SubjectsRepo subjectsRepo;

    @PostMapping("/subject")
    SubjectClass newSubject(@RequestBody SubjectClass newSubjectClass){
        return subjectsRepo.save(newSubjectClass);
    }

    @GetMapping("/subjects")
    List<SubjectClass> getAllSubjects(){
        return subjectsRepo.findAll();
    }

    @GetMapping("/subject/{id}")
    Optional<SubjectClass> getSubjectById(@PathVariable Long id){
        return subjectsRepo.findById(id);

    }

    @DeleteMapping("/subject/{id}")
    String deleteSubject(@PathVariable Long id){
        subjectsRepo.deleteById(id);
        return "Succesfully deleted subject "+id+".";
    }

    @PutMapping("/subject/{id}")
    Optional<SubjectClass> updateSubject(@RequestBody SubjectClass newSubject, @PathVariable Long id){
        return subjectsRepo.findById(id)
                .map(subjectClass ->{
                    subjectClass.setSubject_name(newSubject.getSubject_name());
                    return subjectsRepo.save(subjectClass);

                });
    }
}
