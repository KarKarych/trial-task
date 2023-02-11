package com.example.kameleoon.rest.controller;

import com.example.kameleoon.rest.api.AuthApi;
import com.example.kameleoon.service.logic.AuthService;
import com.example.kameleoon.service.model.auth.TokenResponse;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.auth.UserRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

  private final AuthService authService;

  @Override
  @PostMapping("/register")
  public TokenResponse registerUser(@RequestBody UserRegisterDto userRegisterDto) {
    return authService.registerUser(userRegisterDto);
  }

  @Override
  @PostMapping("/auth")
  public TokenResponse authUser(@RequestBody UserAuthDto userAuthDto) {
    return authService.authUser(userAuthDto);
  }
}
