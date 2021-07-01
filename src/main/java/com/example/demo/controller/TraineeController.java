package com.example.demo.controller;

import com.example.demo.response.TraineeResponse;
import com.example.demo.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/trainees")
public class TraineeController {
    @Autowired
    private TraineeService traineeService;

//    GET /trainers?grouped=false
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TraineeResponse> getTraineeWithoutGroup (@RequestParam("grouped") String grouped){
        return traineeService.getTraineesWithoutGroup();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TraineeResponse saveTrainer (@RequestParam("name") @Valid String name){
        System.out.println(name);
        return traineeService.saveTrainee(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable("id") Long id) {
        traineeService.deleteTrainee(id);
    }
}
