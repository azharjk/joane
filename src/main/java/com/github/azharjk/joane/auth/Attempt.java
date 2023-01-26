package com.github.azharjk.joane.auth;

public class Attempt {
  private final boolean success;
  // TODO: This thing should be the user object
  private final String email;

  public Attempt(boolean success, String email) {
    this.success = success;
    this.email = email;
  }

  public boolean isSuccess() {
    return success;
  }

  public String getEmail() {
    return email;
  }
}
