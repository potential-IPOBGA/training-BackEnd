package com.example.demo.controller;

import com.example.demo.beans.Trainer;
import com.example.demo.response.TrainerResponse;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

//    GET /trainers?grouped=false
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TrainerResponse> getTrainerWithoutGroup (@RequestParam("grouped") String grouped){
        return trainerService.getTrainersWithoutGroup();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerResponse saveTrainer (@RequestParam("name") String name){
        System.out.println(name);
        return trainerService.saveTrainer(name);
    }
}
