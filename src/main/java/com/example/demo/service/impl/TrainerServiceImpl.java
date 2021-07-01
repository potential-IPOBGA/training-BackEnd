package com.example.demo.service.impl;

import com.example.demo.beans.Trainer;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.response.TrainerResponse;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<TrainerResponse> getTrainersWithoutGroup () {
        return trainerRepository.getTrainersByGroup(0L);
    }

    @Override
    public TrainerResponse saveTrainer (String name) {
        final Long trainerId = trainerRepository.saveTrainer(name);
        return new TrainerResponse(trainerId,name);
    }

    @Override
    public void deleteTrainer (Long id) {
        trainerRepository.deleteTrainer(id);
    }

}
