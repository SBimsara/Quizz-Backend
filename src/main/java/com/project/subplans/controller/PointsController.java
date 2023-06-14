package com.project.subplans.controller;

import com.project.subplans.dto.PointsDTO;
import com.project.subplans.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins={"http://localhost:3000","http://192.168.179.177:19000"})
@RestController
@RequestMapping(value = "api/v1/points")
public class PointsController {
    @Autowired
    PointsService pointsService;

    @GetMapping(value = "/getPoints")
    public List<PointsDTO> getpoints() {return pointsService.getPoints();}

    @PostMapping(value = "/savePoints")
    public PointsDTO savepoints(@RequestBody PointsDTO pointsDTO) {
        return pointsService.savePoints(pointsDTO);
    }
}
