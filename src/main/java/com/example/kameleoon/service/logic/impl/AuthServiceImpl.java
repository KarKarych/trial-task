package com.example.kameleoon.service.logic.impl;

import com.example.kameleoon.persistence.entity.User;
import com.example.kameleoon.persistence.repository.UserRepository;
import com.example.kameleoon.security.JwtService;
import com.example.kameleoon.service.exception.ApiException;
import com.example.kameleoon.service.logic.AuthService;
import com.example.kameleoon.service.mapper.AuthMapper;
import com.example.kameleoon.service.model.auth.TokenResponse;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.auth.UserRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;

  private final AuthMapper authMapper;

  private final JwtService jwtService;

  private final AuthenticationManager authenticationManager;

  @Override
  public TokenResponse registerUser(UserRegisterDto userRegisterDto) {
    return Optional.of(userRegisterDto)
      .map(authMapper::toUser)
      .map(userRepository::save)
      .map(this::createTokenResponse)
      .orElseThrow(() -> new ApiException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  public TokenResponse authUser(UserAuthDto userAuthDto) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        userAuthDto.login(),
        userAuthDto.password()
      )
    );

    return userRepository.findByLogin(userAuthDto.login())
      .map(this::createTokenResponse)
      .orElseThrow(() -> new ApiException("login not found", HttpStatus.NOT_FOUND));
  }

  private TokenResponse createTokenResponse(User user) {
    return new TokenResponse(jwtService.generateToken(user));
  }
}
