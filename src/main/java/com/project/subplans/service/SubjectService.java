package com.project.subplans.service;

import com.project.subplans.dto.SubjectDTO;
import com.project.subplans.entity.SubjectClass;
import com.project.subplans.repo.LessonsRepo;
import com.project.subplans.repo.SubjectsRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class SubjectService {

    @Autowired
    private SubjectsRepo subjectRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired LessonsRepo lessonRepo;

    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        subjectRepo.save(modelMapper.map(subjectDTO, SubjectClass.class));
        return subjectDTO;
    }

    public List<SubjectDTO> getAllSubjects() {
        List<SubjectClass> subjectList = subjectRepo.findAll();
        return modelMapper.map(subjectList, new TypeToken<List<SubjectDTO>>() {
        }.getType());
    }

    public SubjectDTO updateSubject(SubjectDTO subjectDTO) {
        subjectRepo.save(modelMapper.map(subjectDTO, SubjectClass.class));
        return subjectDTO;
    }

    public boolean deleteSubject(SubjectDTO subjectDTO) {
        subjectRepo.delete(modelMapper.map(subjectDTO, SubjectClass.class));
        return true;
    }
    public SubjectDTO getSubjectBySubjectID(String subjectID){
        SubjectClass subject=subjectRepo.getSubjectBySubjectID(subjectID);
        return modelMapper.map(subject,SubjectDTO.class);
    }


//    public SubjectDTO getSubjectBySubjectIDAndGrade(String subjectId,String grade){
//        Subject subject =subjectRepo.getSubjectBySubjectIDAndGrade(subjectId,grade);
//        return modelMapper.map(subject,SubjectDTO.class);
//    }

    public boolean deleteSubjectById(String subjectID){
        long sID = Long.parseLong(subjectID);

        if(subjectRepo.existsById(sID)){
//            Subject subject = subjectRepo.getSubjectBySubjectID(subjectID);
//            subjectRepo.delete(modelMapper.map(subject,Subject.class));
//            return true;
            subjectRepo.deleteById(sID);
            return true;
        }
        return false;
    }

//    public boolean addLessonToSubject(String subjectID, String lessonID){
//
//        if(subjectRepo.existsById(Integer.parseInt(subjectID))){
//            Subject subject = subjectRepo.getSubjectBySubjectID(subjectID);
//
//            if(lessonRepo.existsById(Integer.parseInt(lessonID))){
//                Lesson lesson = lessonRepo.getLessonByLessonID(lessonID);
//
//                subject.getLessons().add(lesson);
//
//                subjectRepo.save(subject);
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }
//
//    public boolean removeLessonFromSubject(String subjectID, String lessonID){
//
//        if(subjectRepo.existsById(Integer.parseInt(subjectID))){
//            Subject subject = subjectRepo.getSubjectBySubjectID(subjectID);
//
//            if(lessonRepo.existsById(Integer.parseInt(lessonID))){
//                Lesson lesson = lessonRepo.getLessonByLessonID(lessonID);
//
//                subject.getLessons().remove(lesson);
//                subjectRepo.save(subject);
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }





}
