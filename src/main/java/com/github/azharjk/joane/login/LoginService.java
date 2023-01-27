package com.github.azharjk.joane.login;

import com.github.azharjk.joane.auth.Attempt;
import com.github.azharjk.joane.auth.AuthResponse;
import com.github.azharjk.joane.auth.AuthService;
import com.github.azharjk.joane.users.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.jwt.JwtEncoder;

public class LoginService {
  private final JwtEncoder jwtEncoder;
  private final AuthService authService;

  public LoginService(JwtEncoder jwtEncoder, AuthService authService) {
    this.jwtEncoder = jwtEncoder;
    this.authService = authService;
  }

  public AuthResponse login(LoginBody body) {
    Attempt attempt = authService.attempt(body.getEmail(), body.getPassword());
    if (!attempt.isSuccess()) {
      throw new BadCredentialsException("Bad credentials");
    }

    User user = attempt.getUser();

    return new AuthResponse(authService.createJwtAccessToken(user));
  }
}
