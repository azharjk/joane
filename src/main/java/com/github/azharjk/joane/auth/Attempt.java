package com.github.azharjk.joane.auth;

import com.github.azharjk.joane.users.User;

public class Attempt {
  private final boolean success;
  private final User user;

  public Attempt(boolean success, User user) {
    this.success = success;
    this.user = user;
  }

  public boolean isSuccess() {
    return success;
  }

  public User getUser() {
    return user;
  }
}
