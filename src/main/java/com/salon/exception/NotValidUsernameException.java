package com.salon.exception;

public class NotValidUsernameException extends RuntimeException {

  public NotValidUsernameException(String message) {
    super(message);
  }
}
