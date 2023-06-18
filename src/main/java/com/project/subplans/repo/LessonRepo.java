package com.project.subplans.repo;

import com.project.subplans.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson,Long> {

//    List<Lesson> findByGradeIdAndSubjectClassIdAndTermId(Long gradeId, Long subjectId, Long termId);

    @Query(value = "SELECT * FROM Lessons WHERE lesson_id = ?1",nativeQuery = true)
    Lesson getLessonById(Long lessonId);
}
