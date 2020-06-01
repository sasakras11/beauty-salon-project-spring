package com.salon.exception;

public class UserIsRegisteredException extends RuntimeException{

    public UserIsRegisteredException(String message){
        super(message);
    }
}
