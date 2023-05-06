package com.project.subplans.controller;

import com.project.subplans.dto.LessonDTO;
import com.project.subplans.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin(origins="http://localhost:3000")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping("/getLessons")
    public List<LessonDTO> getLesson() {
        return lessonService.getAllLessons();
    }

    @PostMapping("/saveLesson")
    public LessonDTO saveLesson(@RequestBody LessonDTO lessonDTO) {
        return lessonService.saveLesson(lessonDTO);
    }
    @PutMapping("/updateLesson")
    public LessonDTO updateLesson(@RequestBody LessonDTO lessonDTO) {
        return lessonService.updateLesson(lessonDTO);
    }

    @DeleteMapping("/deleteLesson")
    public boolean deleteLesson(@RequestBody LessonDTO lessonDTO) {
        return lessonService.deleteLesson(lessonDTO);
    }

    @GetMapping("/getLessonByLessonId/{lessonID}")
    public LessonDTO getLessonByLessonID(@PathVariable String lessonID){
        return lessonService.getLessonByLessonID(lessonID);
    }

    @GetMapping("/getLessonByLessonIDAndSubID/{lessonID}/{subID}")
    public LessonDTO getLessonByLessonIDAndSubID(@PathVariable String lessonID ,@PathVariable String subID){
        System.out.println("Lesson ID :"+ lessonID +"User subject ID :" +subID);
        return lessonService.getLessonByLessonIDAndSubID(lessonID,subID);
    }
}

