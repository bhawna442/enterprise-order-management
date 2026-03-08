package com.bhawnagolchha.orderms.exceptions;

public class UserNotFoundException extends ResourceNotFoundException{

    public UserNotFoundException(String identifierType, Object identifierValue) {
        super("User not found with " + identifierType + ": " + identifierValue);
    }
}
