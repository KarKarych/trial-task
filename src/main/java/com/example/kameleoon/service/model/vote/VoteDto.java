package com.example.kameleoon.service.model.vote;

import com.example.kameleoon.service.model.VoteEnum;
import jakarta.validation.constraints.NotNull;

public record VoteDto(
  @NotNull
  VoteEnum vote
) {
}
