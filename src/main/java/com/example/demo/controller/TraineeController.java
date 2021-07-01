package com.example.demo.controller;

import com.example.demo.beans.Trainee;
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
    public List<Trainee> getTraineeWithoutGroup (@RequestParam("grouped") Boolean grouped){
        return traineeService.getTraineesWithoutGroup(grouped);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee saveTrainer (@RequestBody @Valid Trainee trainee){
        return traineeService.saveTrainee(trainee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable("id") Long id) {
        traineeService.deleteTrainee(id);
    }

}
