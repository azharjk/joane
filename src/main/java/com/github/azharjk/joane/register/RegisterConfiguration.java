package com.github.azharjk.joane.register;

import com.github.azharjk.joane.auth.AuthService;
import com.github.azharjk.joane.users.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class RegisterConfiguration {
  @Bean
  public RegisterService registerService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthService authService) {
    return new RegisterService(userRepository, passwordEncoder, authService);
  }
}
