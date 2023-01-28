package com.github.azharjk.joane.roles;

public enum RoleType {
  READ;

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
