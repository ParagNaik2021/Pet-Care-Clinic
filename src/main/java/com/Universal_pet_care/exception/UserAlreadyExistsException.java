package com.Universal_pet_care.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super((message));
    }
}
