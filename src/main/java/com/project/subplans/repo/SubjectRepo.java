package com.project.subplans.repo;

import com.project.subplans.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepo extends JpaRepository<Subject,Integer> {

    @Query(value = "SELECT * FROM SUBJECT WHERE ID = ?1",nativeQuery = true)
    Subject getSubjectBySubjectID(String subjectId);

    @Query(value = "SELECT * FROM SUBJECT WHERE ID =?1 AND GRADE =?2",nativeQuery = true)
    Subject getSubjectBySubjectIDAndGrade(String subjectId,String grade);

}
