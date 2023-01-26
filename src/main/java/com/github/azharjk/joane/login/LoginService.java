package com.github.azharjk.joane.login;

import java.time.Instant;

import com.github.azharjk.joane.auth.Attempt;
import com.github.azharjk.joane.auth.AuthService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

public class LoginService {
  private static final long TWO_MIN_IN_SEC = 120;
  private final JwtEncoder jwtEncoder;
  private final AuthService authService;

  public LoginService(JwtEncoder jwtEncoder, AuthService authService) {
    this.jwtEncoder = jwtEncoder;
    this.authService = authService;
  }

  public LoginResponse login(LoginBody body) {
    Attempt attempt = authService.attempt(body.getEmail(), body.getPassword());
    if (!attempt.isSuccess()) {
      throw new BadCredentialsException("Bad credentials");
    }

    JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
      .claim("email", attempt.getEmail())
      .expiresAt(Instant.now().plusSeconds(TWO_MIN_IN_SEC))
      .build();

    return new LoginResponse(jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue());
  }
}
