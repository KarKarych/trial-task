package com.example.kameleoon.service.model.quote;

import com.example.kameleoon.service.model.user.UserDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record QuoteDto(
  UUID id,
  UserDto user,
  String content,
  LocalDateTime creationDate,
  LocalDateTime modifiedDate,
  Long upvoteCount,
  Long downvoteCount
) {
}
