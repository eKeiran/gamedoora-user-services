package com.gamedoora.backend.userservices.exceptions;

public class UserCreationException extends RuntimeException{

    private String message;

    public UserCreationException(String message) {
        super(message);
        this.message = message;
    }
}
