package com.example.kameleoon.service.logic.impl;

import com.example.kameleoon.persistence.entity.Vote;
import com.example.kameleoon.persistence.repository.VoteRepository;
import com.example.kameleoon.service.exception.ApiException;
import com.example.kameleoon.service.logic.VoteService;
import com.example.kameleoon.service.model.vote.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

  private final VoteRepository voteRepository;

  @Override
  public void addVote(UUID userId, UUID quoteId, VoteDto voteDto) {
    Optional<Vote> foundVote = voteRepository.findByUserIdAndQuoteId(userId, quoteId);
    if (foundVote.isEmpty()) {
      Vote vote = Vote.builder()
        .vote(voteDto.vote())
        .quoteId(quoteId)
        .userId(userId)
        .build();
      voteRepository.save(vote);
    } else {
      throw new ApiException("vote already exists", HttpStatus.BAD_REQUEST);
    }
  }

  @Override
  public void editVote(UUID userId, UUID quoteId, VoteDto voteDto) {
    voteRepository.findByUserIdAndQuoteId(userId, quoteId)
      .map(v -> v.setVote(voteDto.vote()))
      .orElseThrow(() -> new ApiException("vote not found", HttpStatus.NOT_FOUND));
  }

  @Override
  public void removeVote(UUID userId, UUID quoteId) {
    if (voteRepository.existsByUserIdAndQuoteId(userId, quoteId)) {
      voteRepository.deleteByUserIdAndQuoteId(userId, quoteId);
    } else {
      throw new ApiException("vote not found", HttpStatus.NOT_FOUND);
    }
  }
}
