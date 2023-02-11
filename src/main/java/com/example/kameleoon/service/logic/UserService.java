package com.example.kameleoon.service.logic;

import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.user.UserDto;
import com.example.kameleoon.service.validation.constraint.UserIdExists;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

import java.util.UUID;

public interface UserService {

  UserDto updateUser(
    @NotNull
    @UserIdExists(groups = {Default.class, NotFoundGroup.class})
    UUID userId,
    @NotNull
    @Valid
    UserAuthDto userAuthDto
  );

  void deleteUser(
    @NotNull
    @UserIdExists(groups = {Default.class, NotFoundGroup.class})
    UUID userId
  );
}
