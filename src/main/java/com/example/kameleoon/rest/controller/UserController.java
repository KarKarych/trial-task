package com.example.kameleoon.rest.controller;

import com.example.kameleoon.rest.api.UserApi;
import com.example.kameleoon.security.SecurityService;
import com.example.kameleoon.service.logic.UserService;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements UserApi {

  private final UserService userService;

  private final SecurityService securityService;

  @Override
  @PutMapping
  public UserDto updateUser(@RequestBody UserAuthDto userAuthDto) {
    return userService.updateUser(securityService.getId(), userAuthDto);
  }

  @Override
  @DeleteMapping
  public void deleteUser() {
    userService.deleteUser(securityService.getId());
  }
}
