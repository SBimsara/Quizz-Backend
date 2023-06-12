package com.project.subplans.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LessonDTO {
    private int id;
    private int subID;
    private String lessonName;
}