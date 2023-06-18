package com.project.subplans.repo;

import com.project.subplans.entity.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectsRepo extends JpaRepository<SubjectClass,Long> {

    @Query(value = "SELECT * FROM subjects WHERE subject_id = ?1",nativeQuery = true)
    SubjectClass getSubjectBySubjectID(String subjectId);
}
