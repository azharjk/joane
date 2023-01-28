package com.github.azharjk.joane.roles;

public enum RoleType {
  READ,
  WRITE;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
