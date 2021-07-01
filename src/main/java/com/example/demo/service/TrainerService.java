package com.example.demo.service;

import com.example.demo.beans.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getTrainersWithoutGroup();
}
