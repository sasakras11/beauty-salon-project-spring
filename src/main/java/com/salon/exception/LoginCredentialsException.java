package com.salon.exception;

public class LoginCredentialsException extends RuntimeException{
    public LoginCredentialsException(String message){
        super(message);
    }
}
