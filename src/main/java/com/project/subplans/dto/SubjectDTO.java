package com.project.subplans.dto;

import com.project.subplans.entity.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectDTO {
    private int id;
    private String subjectname;
    private String grade;
    private Set<Lesson> lessons;
}
