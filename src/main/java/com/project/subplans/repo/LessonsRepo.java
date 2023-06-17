package com.project.subplans.repo;

import com.project.subplans.entity.LessonClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonsRepo extends JpaRepository<LessonClass,Long> {

    List<LessonClass> findByGradeIdAndSubjectClassIdAndTermId(Long gradeId, Long subjectId, Long termId);

    @Query(value = "SELECT * FROM LESSON WHERE ID = ?1",nativeQuery = true)
    LessonClass getLessonById(Long lessonId);
}
