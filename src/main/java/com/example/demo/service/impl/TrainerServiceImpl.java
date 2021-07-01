package com.example.demo.service.impl;

import com.example.demo.beans.Trainee;
import com.example.demo.beans.Trainer;
import com.example.demo.exception.TraineeNotFoundException;
import com.example.demo.exception.TrainerNotFoundException;
import com.example.demo.repository.TrainerRepository;
import com.example.demo.response.TrainerResponse;
import com.example.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Trainer> getTrainersWithoutGroup(Boolean grouped) {
        return trainerRepository.findAll()
                .stream()
                .filter(trainer -> trainer.getGrouped().equals(grouped))
                .collect(Collectors.toList());
    }

    @Override
    public Trainer saveTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return trainer;
    }

    @Override
    public void deleteTrainer(Long id) {
        final Optional<Trainer> trainerOptional = trainerRepository.findById(id);
        if (trainerOptional.isEmpty()) {
            throw new TrainerNotFoundException(id);
        }
        trainerRepository.delete(trainerOptional.get());
    }

}
