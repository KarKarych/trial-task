package com.example.kameleoon.service.model.auth;

import com.example.kameleoon.service.validation.constraint.LoginDoesNotExist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRegisterDto(
  @NotBlank
  @Size(min = 5, max = 32)
  @LoginDoesNotExist
  String login,
  @NotBlank
  @Size(min = 6, max = 64)
  String password
) {
}
