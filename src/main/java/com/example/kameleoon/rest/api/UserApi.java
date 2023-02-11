package com.example.kameleoon.rest.api;

import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @PutMapping
  UserDto updateUser(@RequestBody UserAuthDto userAuthDto);

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @DeleteMapping
  void deleteUser();
}
