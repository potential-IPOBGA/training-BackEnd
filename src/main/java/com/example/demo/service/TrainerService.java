package com.example.demo.service;

import com.example.demo.response.TrainerResponse;

import java.util.List;

public interface TrainerService {
    List<TrainerResponse> getTrainersWithoutGroup();

    TrainerResponse saveTrainer(String name);
}
