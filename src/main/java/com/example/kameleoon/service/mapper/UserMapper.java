package com.example.kameleoon.service.mapper;

import com.example.kameleoon.persistence.entity.User;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.user.UserDto;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper
public abstract class UserMapper {

  public abstract UserDto toUserDto(User user);

  public User toUser(UUID userId, UserAuthDto userAuthDto) {
    if (userId == null || userAuthDto == null) {
      return null;
    }

    return User.builder()
      .id(userId)
      .login(userAuthDto.login())
      .password(userAuthDto.password())
      .build();
  }
}
