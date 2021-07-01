package com.example.demo.exception;

public class TraineeNotFoundException extends RuntimeException{
    public TraineeNotFoundException (Long id) {
        super("Cannot find basic info for trainee with id " + id + ".");
    }
}
