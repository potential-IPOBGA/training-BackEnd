package com.example.demo.exception;

public class TrainerNotFoundException extends RuntimeException{
    public TrainerNotFoundException (Long id) {
        super("Cannot find basic info for trainer with id " + id + ".");
    }
}
