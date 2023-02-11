package com.example.kameleoon.rest.controller;

import com.example.kameleoon.rest.api.VoteApi;
import com.example.kameleoon.security.SecurityService;
import com.example.kameleoon.service.logic.VoteService;
import com.example.kameleoon.service.model.vote.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteController implements VoteApi {

  private final VoteService voteService;

  private final SecurityService securityService;

  @Override
  @PostMapping("/quote/{quoteId}")
  public void addVote(@PathVariable UUID quoteId, @RequestBody VoteDto voteDto) {
    voteService.addVote(securityService.getId(), quoteId, voteDto);
  }

  @Override
  @PutMapping("/quote/{quoteId}")
  public void editVote(@PathVariable UUID quoteId, @RequestBody VoteDto voteDto) {
    voteService.editVote(securityService.getId(), quoteId, voteDto);
  }

  @Override
  @DeleteMapping("/quote/{quoteId}")
  public void removeVote(@PathVariable UUID quoteId) {
    voteService.removeVote(securityService.getId(), quoteId);
  }
}
