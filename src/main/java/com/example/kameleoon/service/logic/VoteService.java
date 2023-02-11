package com.example.kameleoon.service.logic;

import com.example.kameleoon.service.model.vote.VoteDto;
import com.example.kameleoon.service.validation.constraint.QuoteIdExists;
import com.example.kameleoon.service.validation.constraint.UserIdExists;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

import java.util.UUID;

public interface VoteService {

  void addVote(
    @NotNull
    @UserIdExists(groups = {Default.class, NotFoundGroup.class})
    UUID userId,
    @NotNull
    @QuoteIdExists(groups = {Default.class, NotFoundGroup.class})
    UUID quoteId,
    @Valid
    VoteDto voteDto
  );

  void editVote(
    @NotNull
    UUID userId,
    @NotNull
    UUID quoteId,
    @Valid
    VoteDto voteDto
  );

  void removeVote(
    @NotNull
    UUID userId,
    @NotNull
    UUID quoteId
  );
}
