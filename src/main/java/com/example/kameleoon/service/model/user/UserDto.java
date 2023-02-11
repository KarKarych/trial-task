package com.example.kameleoon.service.model.user;

import java.util.UUID;

public record UserDto(
  UUID id,
  String login
) {
}
