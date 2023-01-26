package com.github.azharjk.joane.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {
  @Bean
  public AuthService authService() {
    return new AuthService();
  }
}
