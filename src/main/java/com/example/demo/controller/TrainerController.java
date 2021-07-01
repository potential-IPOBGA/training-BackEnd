package com.example.demo.controller;

import com.example.demo.beans.Trainer;
import com.example.demo.response.TrainerResponse;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

//    GET /trainers?grouped=false
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Trainer> getTrainerWithoutGroup (@RequestParam("grouped") Boolean grouped){
        return trainerService.getTrainersWithoutGroup(grouped);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer saveTrainer (@RequestBody @Valid Trainer trainer){
        return trainerService.saveTrainer(trainer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable("id") Long id) {
        trainerService.deleteTrainer(id);
    }

}
