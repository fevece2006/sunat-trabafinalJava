package com.fvelasquez.prueba.infraestructure.adapter;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
