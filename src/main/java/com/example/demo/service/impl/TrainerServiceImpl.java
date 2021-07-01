package com.example.demo.service.impl;

import com.example.demo.beans.Trainer;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getTrainersWithoutGroup () {
        return trainerRepository.getTrainersByGroup(0L);
    }

}
