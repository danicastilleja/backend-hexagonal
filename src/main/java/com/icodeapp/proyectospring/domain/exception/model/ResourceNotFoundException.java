package com.icodeapp.proyectospring.domain.exception.model;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
