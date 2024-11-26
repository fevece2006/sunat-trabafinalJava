package com.fvelasquez.prueba.infraestructure.adapter;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}