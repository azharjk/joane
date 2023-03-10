package com.github.azharjk.joane.auth;

import com.github.azharjk.joane.users.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@Configuration
public class AuthConfiguration {
  @Bean
  public AuthService authService(UserRepository userRepository, JwtEncoder jwtEncoder, PasswordEncoder passwordEncoder) {
    return new AuthService(userRepository, jwtEncoder, passwordEncoder);
  }
}
