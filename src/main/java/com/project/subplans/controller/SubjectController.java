package com.project.subplans.controller;

import com.project.subplans.entity.Subject;
import com.project.subplans.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/sub")
@CrossOrigin(origins={"*"})
public class SubjectController {
    @Autowired
    private SubjectRepo subjectRepo;

    @PostMapping("/subject")
    Subject newSubject(@RequestBody Subject newSubject){
        return subjectRepo.save(newSubject);
    }

    @GetMapping("/subjects")
    List<Subject> getAllSubjects(){
        return subjectRepo.findAll();
    }

    @GetMapping("/subject/{id}")
    Optional<Subject> getSubjectById(@PathVariable Long id){
        return subjectRepo.findById(id);

    }

    @DeleteMapping("/subject/{id}")
    String deleteSubject(@PathVariable Long id){
        subjectRepo.deleteById(id);
        return "Succesfully deleted subject "+id+".";
    }

    @PutMapping("/subject/{id}")
    Optional<Subject> updateSubject(@RequestBody Subject newSubject, @PathVariable Long id){
        return subjectRepo.findById(id)
                .map(subjectClass ->{
                    subjectClass.setSubject_name(newSubject.getSubject_name());
                    return subjectRepo.save(subjectClass);

                });
    }
}
