package com.example.kameleoon.service.logic.impl;

import com.example.kameleoon.persistence.repository.UserRepository;
import com.example.kameleoon.service.exception.ApiException;
import com.example.kameleoon.service.logic.UserService;
import com.example.kameleoon.service.mapper.UserMapper;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  @Override
  public UserDto updateUser(UUID userId, UserAuthDto userAuthDto) {
    return Optional.of(userAuthDto)
      .map(dto -> userMapper.toUser(userId, dto))
      .map(userRepository::save)
      .map(userMapper::toUserDto)
      .orElseThrow(() -> new ApiException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  public void deleteUser(UUID userId) {
    userRepository.deleteById(userId);
  }
}
