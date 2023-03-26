package com.project.subplans.service;

import com.project.subplans.dto.SubscriptionDTO;
import com.project.subplans.entity.Subscription;
import com.project.subplans.repo.SubscriptionStatRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SubscriptionStatService {
    @Autowired
    private  SubscriptionStatRepo subscriptionStatRepo;

    @Autowired
    private ModelMapper modelMapper;

    public SubscriptionDTO saveSubscripion(SubscriptionDTO subscriptionDTO){
        subscriptionStatRepo.save(modelMapper.map(subscriptionDTO, Subscription.class));
        return subscriptionDTO;
    }

    public List<SubscriptionDTO> getSubscriptionData(){
        List<Subscription>subscriptionList = subscriptionStatRepo.findAll();
        return modelMapper.map(subscriptionList, new TypeToken<List<SubscriptionDTO>>(){}.getType()); //ArrayList
    }

//    public int getfreeplanuserscount(){
//        int count = subscriptionStatRepo.getFreePlanUserCount();
//        return count;
//    }

    public int[] getPlanUsersCount(){
        int[] count = new int[4];
        count[0] = subscriptionStatRepo.getFreePlanUserCount();
        count[1] = subscriptionStatRepo.getBronzePlanUserCount();
        count[2] = subscriptionStatRepo.getSilverPlanUserCount();
        count[3] = subscriptionStatRepo.getGoldPlanUserCount();
        return count;
    }

}
