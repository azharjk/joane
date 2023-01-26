package com.github.azharjk.joane.security;

import java.security.interfaces.RSAPublicKey;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // TODO: Handle exception handler consistently
    return http
      .csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
      .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/api/login").permitAll()
      .anyRequest().authenticated().and()
      .build();
  }

  @Bean
  public RSAKeyService rsaKeyService() throws JOSEException {
    return RSAKeyService.create();
  }

  @Bean
  public JwtEncoder jwtEncoder(RSAKeyService rsaKeyService) {
    JWKSet jwkSet = new JWKSet(rsaKeyService.getKey());
    ImmutableJWKSet<SecurityContext> immutableJWKSet = new ImmutableJWKSet<>(jwkSet);
    return new NimbusJwtEncoder(immutableJWKSet);
  }

  @Bean
  public JwtDecoder jwtDecoder(RSAKeyService rsaKeyService)throws JOSEException {
    return NimbusJwtDecoder.withPublicKey((RSAPublicKey) rsaKeyService.getKey().toPublicKey()).build();
  }
}
