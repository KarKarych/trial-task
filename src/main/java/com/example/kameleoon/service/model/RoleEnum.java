package com.example.kameleoon.service.model;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {

  USER;

  @Override
  public String getAuthority() {
    return USER.name();
  }
}
