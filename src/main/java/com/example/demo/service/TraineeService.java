package com.example.demo.service;

import com.example.demo.beans.Trainee;
import com.example.demo.response.TraineeResponse;
import com.example.demo.response.TrainerResponse;

import java.util.List;

public interface TraineeService {
    List<Trainee> getTraineesWithoutGroup(Boolean grouped);

    Trainee saveTrainee(Trainee trainee);

    void deleteTrainee(Long id);
}
