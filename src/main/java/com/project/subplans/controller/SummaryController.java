package com.project.subplans.controller;

import com.project.subplans.dto.PointsDTO;
import com.project.subplans.dto.SubscriptionDTO;
import com.project.subplans.dto.SummaryDTO;
import com.project.subplans.service.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/summary")
@CrossOrigin(origins="http://192.168.1.4:19000")
public class SummaryController {
    @Autowired
    SummaryService summaryService;

    @GetMapping(value = "/getSummary")
    public List<SummaryDTO> getsummary(){
        return summaryService.getSummary();
    }

    @PostMapping(value = "/saveSummary")
    public SummaryDTO savesummary(@RequestBody SummaryDTO summaryDTO) {
        return summaryService.saveSummary(summaryDTO);
    }

}
