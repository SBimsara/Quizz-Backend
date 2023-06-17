package com.project.subplans.controller;

import com.project.subplans.entity.LessonClass;
import com.project.subplans.entity.SubjectClass;
import com.project.subplans.exception.ResourceNotFoundException;
import com.project.subplans.repo.LessonsRepo;
import com.project.subplans.service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class LessonsController {
    @Autowired
    private LessonsRepo lessonsRepo;

    @Autowired
    private LessonsService lessonsService;



    @PostMapping("/lesson")
    LessonClass newLesson(@RequestBody LessonClass newLessonClass) {
        return lessonsRepo.save(newLessonClass);
    }

    @GetMapping("/lessons")
    public ResponseEntity<List<LessonClass>> getLessonsByGradeSubjectTerm(
            @RequestParam("gradeId") Long gradeId,
            @RequestParam("subjectId") Long subjectId,
            @RequestParam("termId") Long termId

    ){
        List<LessonClass> lessonClasses = lessonsService.getLessonsByGradeSubjectTerm(gradeId, subjectId, termId);
        return ResponseEntity.ok(lessonClasses);
    }

    @GetMapping("/getalllessons")
    List<LessonClass> getAllLessons(){
        return lessonsRepo.findAll();
    }

    @GetMapping("/lesson/{id}")
    Optional<LessonClass> getLessonById(@PathVariable Long id) {
        return lessonsRepo.findById(id);
    }

    @PutMapping("/lesson/{id}")
    public LessonClass updateLesson(@PathVariable Long id,@RequestBody LessonClass updatedLesson ) {
        LessonClass lessonClass = lessonsRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id"+id));
        lessonClass.setLesson_name(updatedLesson.getLesson_name());
        lessonClass.setGrade(updatedLesson.getGrade());
        lessonClass.setSubject(updatedLesson.getSubject());
        lessonClass.setTerm(updatedLesson.getTerm());


        return lessonsRepo.save(lessonClass);

    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException ex){
        return ex.getMessage();
    }

    @DeleteMapping("/lesson/{id}")
    String deleteLesson(@PathVariable Long id){
        lessonsRepo.deleteById(id);
        return "Succesfully deleted lesson "+id+".";
    }



}
