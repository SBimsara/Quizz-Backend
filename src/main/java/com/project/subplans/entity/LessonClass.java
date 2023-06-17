package com.project.subplans.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
public class LessonClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grade_id",referencedColumnName = "grade_id")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "subject_id")
    private SubjectClass subjectClass;

    @ManyToOne
    @JoinColumn(name = "term_id",referencedColumnName = "term_id")
    private Term term;

    private String lesson_name;

    public Long getLesson_id() {
        return id;
    }

    public void setLesson_id(Long lesson_id) {
        this.id = lesson_id;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public SubjectClass getSubject() {
        return subjectClass;
    }

    public void setSubject(SubjectClass subjectClass) {
        this.subjectClass = subjectClass;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }
}
