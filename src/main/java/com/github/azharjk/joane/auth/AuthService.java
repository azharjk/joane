package com.github.azharjk.joane.auth;

import com.github.azharjk.joane.users.User;
import com.github.azharjk.joane.users.UserRepository;

import java.util.Optional;

public class AuthService {
  private UserRepository userRepository;

  public AuthService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Attempt attempt(String email, String password) {
    Optional<User> optUser = userRepository.findByEmail(email);
    if (optUser.isEmpty()) {
      return new Attempt(false, null);
    }

    User user = optUser.get();

    if (password.equals(user.getPassword())) {
      return new Attempt(true, user);
    }

    return new Attempt(false, null);
  }
}
