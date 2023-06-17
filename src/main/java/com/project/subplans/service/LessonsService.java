package com.project.subplans.service;


import com.project.subplans.entity.LessonClass;
import com.project.subplans.repo.LessonsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonsService {

    @Autowired
    private LessonsRepo lessonsRepo;

    public List<LessonClass> getLessonsByGradeSubjectTerm(Long gradeId, Long subjectId, Long termId) {
        return lessonsRepo.findByGradeIdAndSubjectClassIdAndTermId(gradeId, subjectId, termId);
    }

    public LessonClass getLessonById(Long id){
        return lessonsRepo.getLessonById(id);
    }
}
