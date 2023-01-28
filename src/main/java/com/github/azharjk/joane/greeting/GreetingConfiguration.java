package com.github.azharjk.joane.greeting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfiguration {
  @Bean
  public GreetingService greetingService() {
    return new GreetingService();
  }
}
