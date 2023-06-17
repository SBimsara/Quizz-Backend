package com.project.subplans.dto;



import com.project.subplans.entity.Subject;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LessonDTO {
    private int id;
    private String lessonName;
    private int term;
    private Subject subject;



}