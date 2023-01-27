package com.github.azharjk.joane.auth;

import java.time.Instant;
import java.util.Optional;

import com.github.azharjk.joane.users.User;
import com.github.azharjk.joane.users.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

public class AuthService {
  private static final Long TWO_MINUTES_IN_SECONDS = 120L;
  private final UserRepository userRepository;
  private final JwtEncoder jwtEncoder;
  private final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository userRepository, JwtEncoder jwtEncoder, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.jwtEncoder = jwtEncoder;
    this.passwordEncoder = passwordEncoder;
  }

  public Attempt attempt(String email, String password) {
    Optional<User> optUser = userRepository.findByEmail(email);
    if (optUser.isEmpty()) {
      return new Attempt(false, null);
    }

    User user = optUser.get();

    if (passwordEncoder.matches(password, user.getPassword())) {
      return new Attempt(true, user);
    }

    return new Attempt(false, null);
  }

  public String createJwtAccessToken(User user) {
    Instant expiresAt = Instant.now().plusSeconds(TWO_MINUTES_IN_SECONDS);

    JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
      .subject(user.getId().toString())
      .claim("email", user.getEmail())
      .expiresAt(expiresAt)
      .build();

    return jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
  }
}
