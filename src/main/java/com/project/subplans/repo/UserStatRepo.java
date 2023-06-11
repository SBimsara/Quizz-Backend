package com.project.subplans.repo;

import com.project.subplans.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserStatRepo extends JpaRepository <User,Integer>{
    @Query(value="SELECT count(id) FROM User",nativeQuery = true)
    int getUserCount();
}
