package com.github.azharjk.joane.auth;

public class AuthService {
  public Attempt attempt(String email, String password) {
    // TODO: 1. Look to database if the email exists
    //       2. otherwise return false
    //       3. Continue compare password and so on
    //       4. and return true in the end

    if (email.equals("king@mail.com") && password.equals("12345")) {
      return new Attempt(true, "king@mail.com");
    }

    return new Attempt(false, null);
  }
}
