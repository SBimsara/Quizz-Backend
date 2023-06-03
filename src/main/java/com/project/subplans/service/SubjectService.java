package com.project.subplans.service;

import com.project.subplans.dto.SubjectDTO;
import com.project.subplans.entity.Lesson;
import com.project.subplans.entity.Subject;
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
public class SubjectService {

    @Autowired
    private SubjectRepo subjectRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired LessonRepo lessonRepo;

    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        subjectRepo.save(modelMapper.map(subjectDTO, Subject.class));
        return subjectDTO;
    }

    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjectList = subjectRepo.findAll();
        return modelMapper.map(subjectList, new TypeToken<List<SubjectDTO>>() {
        }.getType());
    }

    public SubjectDTO updateSubject(SubjectDTO subjectDTO) {
        subjectRepo.save(modelMapper.map(subjectDTO, Subject.class));
        return subjectDTO;
    }

    public boolean deleteSubject(SubjectDTO subjectDTO) {
        subjectRepo.delete(modelMapper.map(subjectDTO, Subject.class));
        return true;
    }
    public SubjectDTO getSubjectBySubjectID(String subjectID){
        Subject subject=subjectRepo.getSubjectBySubjectID(subjectID);
        return modelMapper.map(subject,SubjectDTO.class);
    }


    public SubjectDTO getSubjectBySubjectIDAndGrade(String subjectId,String grade){
        Subject subject =subjectRepo.getSubjectBySubjectIDAndGrade(subjectId,grade);
        return modelMapper.map(subject,SubjectDTO.class);
    }

    public boolean deleteSubjectById(String subjectID){
        int sID = Integer.parseInt(subjectID);

        if(subjectRepo.existsById(sID)){
//            Subject subject = subjectRepo.getSubjectBySubjectID(subjectID);
//            subjectRepo.delete(modelMapper.map(subject,Subject.class));
//            return true;
            subjectRepo.deleteById(sID);
            return true;
        }
        return false;
    }

    public boolean addLessonToSubject(String subjectID, String lessonID){

        if(subjectRepo.existsById(Integer.parseInt(subjectID))){
            Subject subject = subjectRepo.getSubjectBySubjectID(subjectID);

            if(lessonRepo.existsById(Integer.parseInt(lessonID))){
                Lesson lesson = lessonRepo.getLessonByLessonID(lessonID);

                subject.getLessons().add(lesson);

                subjectRepo.save(subject);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean removeLessonFromSubject(String subjectID, String lessonID){

        if(subjectRepo.existsById(Integer.parseInt(subjectID))){
            Subject subject = subjectRepo.getSubjectBySubjectID(subjectID);

            if(lessonRepo.existsById(Integer.parseInt(lessonID))){
                Lesson lesson = lessonRepo.getLessonByLessonID(lessonID);

                subject.getLessons().remove(lesson);
                subjectRepo.save(subject);
                return true;
            }
            return false;
        }
        return false;
    }





}
