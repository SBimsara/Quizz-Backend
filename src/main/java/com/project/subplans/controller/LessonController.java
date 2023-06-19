package com.project.subplans.controller;

import com.project.subplans.entity.Lesson;
import com.project.subplans.exception.ResourceNotFoundException;
import com.project.subplans.repo.LessonRepo;
import com.project.subplans.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/lesson")
@CrossOrigin(origins={"*"})
public class LessonController {
    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private LessonService lessonService;



    @PostMapping("/lesson")
    Lesson newLesson(@RequestBody Lesson newLesson) {
        return lessonRepo.save(newLesson);
    }

//    @GetMapping("/lessons")
//    public ResponseEntity<List<Lesson>> getLessonsByGradeSubjectTerm(
//            @RequestParam("gradeId") Long gradeId,
//            @RequestParam("subjectId") Long subjectId,
//            @RequestParam("termId") Long termId
//
//    ){
//        List<Lesson> lesson = lessonService.getLessonsByGradeSubjectTerm(gradeId, subjectId, termId);
//        return ResponseEntity.ok(lesson);
//    }

    @GetMapping("/getalllessons")
    List<Lesson> getAllLessons(){
        return lessonRepo.findAll();
    }

    @GetMapping("/lesson/{id}")
    Optional<Lesson> getLessonById(@PathVariable Long id) {
        return lessonRepo.findById(id);
    }

    @PutMapping("/lesson/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson updatedLesson) {
        Lesson lesson = lessonRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with id"+id));
        lesson.setLesson_name(updatedLesson.getLesson_name());
        lesson.setGrade(updatedLesson.getGrade());
        lesson.setSubject(updatedLesson.getSubject());
        lesson.setTerm(updatedLesson.getTerm());


        return lessonRepo.save(lesson);

    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException ex){
        return ex.getMessage();
    }

    @DeleteMapping("/lesson/{id}")
    String deleteLesson(@PathVariable Long id){
        lessonRepo.deleteById(id);
        return "Succesfully deleted lesson "+id+".";
    }



}
