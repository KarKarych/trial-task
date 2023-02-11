package com.example.kameleoon.rest.api;

import com.example.kameleoon.service.model.auth.TokenResponse;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.auth.UserRegisterDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthApi {

  @PostMapping("/register")
  TokenResponse registerUser(@RequestBody UserRegisterDto userRegisterDto);

  @PostMapping("/auth")
  TokenResponse authUser(@RequestBody UserAuthDto userAuthDto);
}
