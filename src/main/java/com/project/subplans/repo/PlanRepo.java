package com.project.subplans.repo;

import com.project.subplans.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlanRepo extends JpaRepository<Plan,Integer> {

    @Query( value = "SELECT * FROM plan WHERE pid=?1" ,nativeQuery = true)
    Plan getPlanById(String planId);

}
