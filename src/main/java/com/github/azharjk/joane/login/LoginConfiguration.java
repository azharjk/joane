package com.github.azharjk.joane.login;

import com.github.azharjk.joane.auth.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@Configuration
public class LoginConfiguration {
  @Bean
  public LoginService loginService(JwtEncoder jwtEncoder, AuthService authService) {
    return new LoginService(jwtEncoder, authService);
  }
}
