package com.github.azharjk.joane.greeting;

import com.github.azharjk.joane.utils.JoaneResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {
  @PreAuthorize("hasAuthority('SCOPE_read')")
  @GetMapping
  public JoaneResponse<Void, String> greeting(@AuthenticationPrincipal Jwt jwt) {
    String email = jwt.getClaimAsString("email");
    return new JoaneResponse<>(null, "Hello %s, from Joane".formatted(email));
  }
}
