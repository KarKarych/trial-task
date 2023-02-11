package com.example.kameleoon.service.model.auth;

import com.example.kameleoon.service.validation.constraint.LoginExists;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;

public record UserAuthDto(
  @NotBlank
  @Size(min = 5, max = 32)
  @LoginExists(groups = {Default.class, NotFoundGroup.class})
  String login,
  @NotBlank
  @Size(min = 6, max = 64)
  String password
) {
}
