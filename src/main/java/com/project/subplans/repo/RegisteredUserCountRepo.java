package com.project.subplans.repo;

import com.project.subplans.entity.RegisteredUserCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface RegisteredUserCountRepo extends JpaRepository <RegisteredUserCount, Date> {

    @Query(value = "select date, count from registered_user_count where  date > (SELECT max(date) from registered_user_count) - INTERVAL ?1 MONTH ", nativeQuery = true)
    List<RegisteredUserCount> getRegisteredUserCountbyMonths(int months);
}
