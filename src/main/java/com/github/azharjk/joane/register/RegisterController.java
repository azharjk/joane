package com.github.azharjk.joane.register;

import com.github.azharjk.joane.auth.AuthResponse;
import com.github.azharjk.joane.utils.JoaneResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
  private final RegisterService registerService;

  public RegisterController(RegisterService registerService) {
    this.registerService = registerService;
  }

  @PostMapping
  public JoaneResponse<Void, AuthResponse> register(@RequestBody @Valid RegisterBody registerBody) {
    return new JoaneResponse<>(null, registerService.register(registerBody));
  }
}
