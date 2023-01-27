package com.github.azharjk.joane.auth;

import com.github.azharjk.joane.users.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {
  @Bean
  public AuthService authService(UserRepository userRepository) {
    return new AuthService(userRepository);
  }
}
