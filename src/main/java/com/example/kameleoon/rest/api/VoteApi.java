package com.example.kameleoon.rest.api;

import com.example.kameleoon.service.model.vote.VoteDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface VoteApi {

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @PostMapping("/quote/{quoteId}")
  void addVote(@PathVariable UUID quoteId, @RequestBody VoteDto voteDto);

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @PutMapping("/quote/{quoteId}")
  void editVote(@PathVariable UUID quoteId, @RequestBody VoteDto voteDto);

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @DeleteMapping("/quote/{quoteId}")
  void removeVote(@PathVariable UUID quoteId);
}
