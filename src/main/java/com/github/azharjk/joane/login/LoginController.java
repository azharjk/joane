package com.github.azharjk.joane.login;

import com.github.azharjk.joane.utils.JoaneResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
  private final LoginService loginService;

  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @PostMapping
  public JoaneResponse<Void, LoginResponse> login(@RequestBody @Valid LoginBody body) {
    return new JoaneResponse<>(null, loginService.login(body));
  }
}
