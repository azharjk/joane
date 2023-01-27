package com.github.azharjk.joane.exception;

public class EmailAlreadyRegisteredException extends RuntimeException {
  public EmailAlreadyRegisteredException() {
    super("Email is already registered");
  }
}
