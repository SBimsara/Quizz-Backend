package com.project.subplans.repo;

import com.project.subplans.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepo extends JpaRepository <Summary,Integer> {
}
