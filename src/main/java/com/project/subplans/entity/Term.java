package com.project.subplans.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "term")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "term_id")
    private Long id;

    private String term_name;

    public Long getTerm_id() {
        return id;
    }

    public void setTerm_id(Long term_id) {
        this.id = term_id;
    }

    public String getTerm_name() {
        return term_name;
    }

    public void setTerm_name(String term_name) {
        this.term_name = term_name;
    }
}
