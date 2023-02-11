package com.example.kameleoon.service.mapper;

import com.example.kameleoon.persistence.entity.User;
import com.example.kameleoon.service.model.auth.UserRegisterDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper
public abstract class AuthMapper {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User toUser(UserRegisterDto userInputDto) {
    if (userInputDto == null) {
      return null;
    }

    return User.builder()
      .login(userInputDto.login())
      .password(passwordEncoder.encode(userInputDto.password()))
      .build();
  }
}
