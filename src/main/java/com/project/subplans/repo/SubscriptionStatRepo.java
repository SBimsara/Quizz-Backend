package com.project.subplans.repo;

import com.project.subplans.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionStatRepo extends JpaRepository <Subscription,Integer> {
    @Query(value = "SELECT count(id) FROM Subscription WHERE planID=1000",nativeQuery = true)
    int getFreePlanUserCount();

    @Query(value = "SELECT count(id) FROM Subscription WHERE planID=1010",nativeQuery = true)
    int getBronzePlanUserCount();

    @Query(value = "SELECT count(id) FROM Subscription WHERE planID=2010",nativeQuery = true)
    int getSilverPlanUserCount();

    @Query(value = "SELECT count(id) FROM Subscription WHERE planID=3010",nativeQuery = true)
    int getGoldPlanUserCount();
}
