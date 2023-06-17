package com.project.subplans.repo;

import com.project.subplans.entity.Term;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermRepo extends JpaRepository<Term,Long> {
}
