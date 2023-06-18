package com.project.subplans.service;


import com.project.subplans.entity.Lesson;
import com.project.subplans.repo.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepo lessonRepo;

//    public List<Lesson> getLessonsByGradeSubjectTerm(Long gradeId, Long subjectId, Long termId) {
//        return lessonRepo.findByGradeIdAndSubjectClassIdAndTermId(gradeId, subjectId, termId);
//    }

    public Lesson getLessonById(Long id){
        return lessonRepo.getLessonById(id);
    }
}
