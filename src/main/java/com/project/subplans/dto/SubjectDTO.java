package com.project.subplans.dto;



import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectDTO {
    private int id;
    private String subjectname;
    private String grade;
    private Set<Lesson> lessons;

    private Set<Plan> plans;

}
