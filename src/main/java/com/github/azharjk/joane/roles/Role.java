package com.github.azharjk.joane.roles;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "roles")
public class Role {
  public static final Long READ_ID = 1L;
  @Id
  private Long id;
  @Enumerated(EnumType.STRING)
  private RoleType type;

  public Role() {
  }

  public Role(Long id, RoleType type) {
    this.id = id;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RoleType getType() {
    return type;
  }

  public void setType(RoleType type) {
    this.type = type;
  }
}
