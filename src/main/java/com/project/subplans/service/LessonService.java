package com.project.subplans.service;

import com.project.subplans.dto.LessonDTO;
import com.project.subplans.entity.Lesson;
import com.project.subplans.repo.LessonRepo;
import com.project.subplans.repo.SubjectRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class LessonService {

    @Autowired
    private LessonRepo lessonRepo;

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private ModelMapper modelMapper;

    public LessonDTO saveLesson(LessonDTO lessonDTO){
        lessonRepo.save(modelMapper.map(lessonDTO, Lesson.class));
        return lessonDTO;
    }
    public List<LessonDTO> getAllLessons(){
        List<Lesson>userList=lessonRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<LessonDTO>>(){}.getType());
    }
    public LessonDTO updateLesson(LessonDTO lessonDTO){
        lessonRepo.save(modelMapper.map(lessonDTO,Lesson.class));
        return lessonDTO;
    }
    public boolean deleteLesson(LessonDTO lessonDTO){
        lessonRepo.delete(modelMapper.map(lessonDTO,Lesson.class));
        return true;
    }


    public LessonDTO getLessonByLessonID(String lessonID){
        Lesson lesson=lessonRepo.getLessonByLessonID(lessonID);
        return modelMapper.map(lesson,LessonDTO.class);
    }


    public LessonDTO getLessonByLessonIDAndSubID(String lessonId,String subID){
        Lesson lesson =lessonRepo.getLessonByLessonIDAndSubID(lessonId,subID);
        return modelMapper.map(lesson,LessonDTO.class);
    }




}