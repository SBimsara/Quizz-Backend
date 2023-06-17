package com.project.subplans.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quiz_type")
public class QuizType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quiz_type_id;
    private String quiz_type_name;

    public Long getQuiz_type_id() {
        return quiz_type_id;
    }

    public void setQuiz_type_id(Long quiz_type_id) {
        this.quiz_type_id = quiz_type_id;
    }

    public String getQuiz_type_name() {
        return quiz_type_name;
    }

    public void setQuiz_type_name(String quiz_type_name) {
        this.quiz_type_name = quiz_type_name;
    }
}
