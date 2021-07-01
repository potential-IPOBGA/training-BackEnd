package com.example.demo.service.impl;

import com.example.demo.beans.Trainee;
import com.example.demo.exception.TraineeNotFoundException;
import com.example.demo.exception.TrainerNotFoundException;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.response.TraineeResponse;
import com.example.demo.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;

    @Override
    public List<Trainee> getTraineesWithoutGroup (Boolean grouped) {
        return traineeRepository.findAll().stream().filter(trainee -> trainee.getGrouped().equals(grouped)).collect(Collectors.toList());
    }

    @Override
    public Trainee saveTrainee (Trainee trainee) {
        return traineeRepository.save(trainee);
    }

    @Override
    public void deleteTrainee (Long id) {
        final Optional<Trainee> traineeOptional = traineeRepository.findById(id);
        if (traineeOptional.isEmpty()){
            throw new TraineeNotFoundException(id);
        }
        traineeRepository.delete(traineeOptional.get());
    }

}
