package com.github.azharjk.joane.security;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

public class RSAKeyService {
  private static final int SIZE = 2048;
  private final RSAKey key;

  public static RSAKeyService create() throws JOSEException {
    RSAKey rsaKey = (new RSAKeyGenerator(SIZE)).generate();
    return new RSAKeyService(rsaKey);
  }

  private RSAKeyService(RSAKey rsaKey) {
    this.key = rsaKey;
  }

  public RSAKey getKey() {
    return key;
  }
}
