package com.example.kameleoon.rest.controller;

import com.example.kameleoon.rest.api.QuoteApi;
import com.example.kameleoon.security.SecurityService;
import com.example.kameleoon.service.logic.QuoteService;
import com.example.kameleoon.service.model.PageDto;
import com.example.kameleoon.service.model.quote.QuoteDto;
import com.example.kameleoon.service.model.quote.QuoteInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/quotes")
@RequiredArgsConstructor
public class QuoteController implements QuoteApi {

  private final QuoteService quoteService;

  private final SecurityService securityService;

  @Override
  @GetMapping("/random")
  public QuoteDto getRandomQuote() {
    return quoteService.getRandomQuote();
  }

  @Override
  @GetMapping("/top")
  public List<QuoteDto> getTop10Quotes() {
    return quoteService.getTop10Quotes();
  }

  @Override
  @GetMapping("/flop")
  public List<QuoteDto> getFlop10Quotes() {
    return quoteService.getFlop10Quotes();
  }

  @Override
  @GetMapping("/last")
  public PageDto<QuoteDto> getLastQuotes(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "10") Integer pageSize
  ) {
    return quoteService.getLastQuotes(pageNumber, pageSize);
  }

  @Override
  @GetMapping("/user")
  public PageDto<QuoteDto> getLastQuotesByCurrentUser(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize
  ) {
    return quoteService.getLastQuotesByUser(securityService.getId(), pageNumber, pageSize);
  }

  @Override
  @PostMapping
  public QuoteDto saveQuote(@RequestBody QuoteInputDto quoteInputDto) {
    return quoteService.saveQuote(securityService.getId(), quoteInputDto);
  }

  @Override
  @PutMapping("/{quoteId}")
  public QuoteDto updateQuote(@PathVariable UUID quoteId, @RequestBody QuoteInputDto quoteInputDto) {
    return quoteService.updateQuote(securityService.getId(), quoteId, quoteInputDto);
  }

  @Override
  @DeleteMapping("/{quoteId}")
  public void deleteQuote(@PathVariable UUID quoteId) {
    quoteService.deleteQuote(securityService.getId(), quoteId);
  }
}
