
/*

 This interface represents the repository for Admin entity, which extends JpaRepository to provide basic CRUD operations.
 */
package com.project.subplans.repo;

import com.project.subplans.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/*
 * This method is used to fetch the admin data from the database based on their unique identifiers like NIC, email, username, and contact number.
 * @param nic unique identifier of admin
 * @param contactNumber unique identifier of admin
 * @param email unique identifier of admin
 * @param username unique identifier of admin
 * @return Admin object that matches the given parameters
 */

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    @Query(value = "SELECT * FROM admin WHERE username=?1 AND nic=?2 AND email=?3 AND contactNumber=?4", nativeQuery = true)
    Admin getAdmin(String nic, String contactNumber, String email, String username);
    Admin findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByNic(String nic);
    boolean existsByEmail(String email);
    boolean existsByContactNumber(String contactNumber);
  
  @Query(value = "select * from Admins where id=?1",nativeQuery = true)
    Admin getAdminByAdminID(String adminId);

  @Query(value = "select COUNT(id) from Admins",nativeQuery = true)
    int getAdminCountByID();
}

