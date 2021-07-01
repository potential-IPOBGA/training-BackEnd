package com.example.demo.exception;

public class TrainerNumberException extends RuntimeException{
    public TrainerNumberException() {
        super("TrainerNumber less than 2");
    }
}
