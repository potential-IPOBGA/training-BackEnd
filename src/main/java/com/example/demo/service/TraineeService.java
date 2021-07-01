package com.example.demo.service;

import com.example.demo.response.TraineeResponse;
import com.example.demo.response.TrainerResponse;

import java.util.List;

public interface TraineeService {
    List<TraineeResponse> getTraineesWithoutGroup();

    TraineeResponse saveTrainee(String name);

    void deleteTrainee(Long id);
}
