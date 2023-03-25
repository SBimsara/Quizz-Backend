package com.project.subplans.repo;

import com.project.subplans.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionStatRepo extends JpaRepository <Subscription,Integer> {
    @Query(value = "SELECT count(id) FROM Subscription WHERE planID=1000",nativeQuery = true)
    int getFreePlanUserCount();
}
