package com.github.azharjk.joane.greeting;

import org.springframework.security.oauth2.jwt.Jwt;

public class GreetingService {
  public String greeting(Jwt jwt) {
    String email = jwt.getClaimAsString("email");
    String scope = jwt.getClaimAsString("scope");

    return "Hello %s, from greeting your authority '%s'".formatted(email, scope);
  }
}
