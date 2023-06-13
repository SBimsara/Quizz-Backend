package com.project.subplans.repo;

import com.project.subplans.entity.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepo extends JpaRepository<SubjectClass,Long> {
}
