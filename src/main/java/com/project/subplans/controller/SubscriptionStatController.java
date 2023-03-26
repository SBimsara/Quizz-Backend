package com.project.subplans.controller;

import com.project.subplans.dto.SubscriptionDTO;
import com.project.subplans.service.SubscriptionStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "api/v1/subscriptionStat")
public class SubscriptionStatController {
    @Autowired
    SubscriptionStatService subscriptionStatService;

    @GetMapping(value = "/getSubscriptionStat")
    public List<SubscriptionDTO> getSubscriptionStat(){
        return subscriptionStatService.getSubscriptionData();
    }

    @GetMapping(value = "/getPlanUserCount")
    public int[] getPlanUserCount(){
        return subscriptionStatService.getPlanUsersCount();
    }

    @PostMapping(value = "/saveSubscriptionStat")
    public SubscriptionDTO savesubscriptionStat(@RequestBody SubscriptionDTO subscriptionDTO){
        return subscriptionStatService.saveSubscripion(subscriptionDTO);
    }

}
