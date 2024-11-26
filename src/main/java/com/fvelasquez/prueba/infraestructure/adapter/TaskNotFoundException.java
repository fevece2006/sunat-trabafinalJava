package com.fvelasquez.prueba.infraestructure.adapter;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String message) {
        super(message);
    }
}
