package com.example.kameleoon.service.logic.impl;

import com.example.kameleoon.persistence.entity.Quote;
import com.example.kameleoon.persistence.repository.QuoteRepository;
import com.example.kameleoon.persistence.repository.QuoteViewRepository;
import com.example.kameleoon.persistence.repository.UserRepository;
import com.example.kameleoon.service.exception.ApiException;
import com.example.kameleoon.service.logic.QuoteService;
import com.example.kameleoon.service.mapper.QuoteMapper;
import com.example.kameleoon.service.model.PageDto;
import com.example.kameleoon.service.model.quote.QuoteDto;
import com.example.kameleoon.service.model.quote.QuoteInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.domain.Pageable.ofSize;


@Service
@Validated
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

  private final QuoteRepository quoteRepository;

  private final QuoteViewRepository quoteViewRepository;

  private final UserRepository userRepository;

  private final QuoteMapper quoteMapper;

  @Override
  public QuoteDto getRandomQuote() {
    return quoteViewRepository.findRandomQuoteWithVotes()
      .map(quoteMapper::toQuoteDto)
      .orElseThrow(() -> new ApiException("quote not found", HttpStatus.NOT_FOUND));
  }

  @Override
  public List<QuoteDto> getTop10Quotes() {
    return quoteViewRepository.findTop10Quotes()
      .stream()
      .map(quoteMapper::toQuoteDto)
      .toList();
  }

  @Override
  public List<QuoteDto> getFlop10Quotes() {
    return quoteViewRepository.findFlop10Quotes()
      .stream()
      .map(quoteMapper::toQuoteDto)
      .toList();
  }

  @Override
  public PageDto<QuoteDto> getLastQuotes(Integer pageNumber, Integer pageSize) {
    Page<QuoteDto> quotes = quoteViewRepository.getLastQuotes(ofSize(pageSize).withPage(pageNumber))
      .map(quoteMapper::toQuoteDto);

    return new PageDto<>(
      quotes.getContent(),
      pageNumber,
      pageSize,
      quotes.getTotalPages()
    );
  }

  @Override
  public PageDto<QuoteDto> getLastQuotesByUser(UUID userId, Integer pageNumber, Integer pageSize) {
    Pageable pageable = ofSize(pageSize).withPage(pageNumber);
    Page<QuoteDto> quotes = quoteViewRepository.getLastQuotesByUser(userId, pageable)
      .map(quoteMapper::toQuoteDto);

    return new PageDto<>(
      quotes.getContent(),
      pageNumber,
      pageSize,
      quotes.getTotalPages()
    );
  }

  @Override
  public QuoteDto saveQuote(UUID userId, QuoteInputDto quoteInputDto) {
    Quote quoteToSave = Quote.builder()
      .user(userRepository.getReferenceById(userId))
      .content(quoteInputDto.content())
      .build();

    Quote savedQuote = quoteRepository.save(quoteToSave);

    return Optional.of(savedQuote.getId())
      .flatMap(quoteViewRepository::findById)
      .map(quoteMapper::toQuoteDto)
      .orElseThrow(() -> new ApiException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  public QuoteDto updateQuote(UUID userId, UUID quoteId, QuoteInputDto quoteInputDto) {
    Quote quoteToUpdate = Quote.builder()
      .id(quoteId)
      .user(userRepository.getReferenceById(userId))
      .content(quoteInputDto.content())
      .build();

    Quote updatedQuote = quoteRepository.save(quoteToUpdate);

    return Optional.of(updatedQuote.getId())
      .flatMap(quoteViewRepository::findById)
      .map(quoteMapper::toQuoteDto)
      .orElseThrow(() -> new ApiException("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  public void deleteQuote(UUID userId, UUID quoteId) {
    quoteRepository.deleteById(quoteId);
  }
}
