package com.project.subplans.repo;

import com.project.subplans.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LessonRepo extends JpaRepository<Lesson,Integer> {

    @Query(value = "SELECT * FROM LESSON WHERE ID = ?1",nativeQuery = true)
    Lesson getLessonByLessonID(String lessonId);

    @Query(value = "SELECT * FROM LESSON WHERE ID =?1 AND SUBID =?2",nativeQuery = true)
    Lesson getLessonByLessonIDAndSubID(String lessonId,String subID);

}