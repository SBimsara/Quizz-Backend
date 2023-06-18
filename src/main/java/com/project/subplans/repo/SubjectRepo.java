package com.project.subplans.repo;

import com.project.subplans.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepo extends JpaRepository<Subject,Long> {

    @Query(value = "SELECT * FROM subjects WHERE subject_id = ?1",nativeQuery = true)
    Subject getSubjectBySubjectID(String subjectId);
}
