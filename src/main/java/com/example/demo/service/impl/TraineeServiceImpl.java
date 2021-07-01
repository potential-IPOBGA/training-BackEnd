package com.example.demo.service.impl;

import com.example.demo.repository.TraineeRepository;
import com.example.demo.response.TraineeResponse;
import com.example.demo.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;

    @Override
    public List<TraineeResponse> getTraineesWithoutGroup () {
        return traineeRepository.getTraineesByGroup(0L);
    }

    @Override
    public TraineeResponse saveTrainee (String name) {
        final Long traineeId = traineeRepository.saveTrainee(name);
        System.out.println(traineeId);
        return new TraineeResponse(traineeId,name);
    }

    @Override
    public void deleteTrainee (Long id) {
        traineeRepository.deleteTrainee(id);
    }
}
