package com.github.azharjk.joane.register;

import java.util.Optional;

import com.github.azharjk.joane.auth.AuthResponse;
import com.github.azharjk.joane.auth.AuthService;
import com.github.azharjk.joane.exception.EmailAlreadyRegisteredException;
import com.github.azharjk.joane.users.User;
import com.github.azharjk.joane.users.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegisterService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthService authService;

  public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthService authService) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.authService = authService;
  }

  public AuthResponse register(RegisterBody registerBody) {
    Optional<User> optUser = userRepository.findByEmail(registerBody.getEmail());
    if (optUser.isPresent()) {
      throw new EmailAlreadyRegisteredException();
    }

    User user = new User(registerBody.getEmail(), passwordEncoder.encode(registerBody.getPassword()));
    User userModel = userRepository.save(user);

    return new AuthResponse(authService.createJwtAccessToken(userModel));
  }
}
