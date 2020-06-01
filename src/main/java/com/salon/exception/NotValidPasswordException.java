package com.salon.exception;

public class NotValidPasswordException extends RuntimeException {

  public NotValidPasswordException(String message) {
    super(message);
  }
}
