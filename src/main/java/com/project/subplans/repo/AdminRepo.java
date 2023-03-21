package com.project.subplans.repo;


import com.project.subplans.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

    @Query(value = "select * from Admin where id=?1",nativeQuery = true)
    Admin getAdminByAdminID(String adminid);
}
