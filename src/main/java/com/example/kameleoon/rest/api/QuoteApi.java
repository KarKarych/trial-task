package com.example.kameleoon.rest.api;

import com.example.kameleoon.service.model.PageDto;
import com.example.kameleoon.service.model.quote.QuoteDto;
import com.example.kameleoon.service.model.quote.QuoteInputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface QuoteApi {

  @GetMapping("/random")
  QuoteDto getRandomQuote();

  @GetMapping("/top")
  List<QuoteDto> getTop10Quotes();

  @GetMapping("/flop")
  List<QuoteDto> getFlop10Quotes();

  @GetMapping("/last")
  PageDto<QuoteDto> getLastQuotes(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "10") Integer pageSize
  );

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @GetMapping("/user")
  PageDto<QuoteDto> getLastQuotesByCurrentUser(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize
  );

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @PostMapping
  QuoteDto saveQuote(@RequestBody QuoteInputDto quoteInputDto);

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @PutMapping("/{quoteId}")
  QuoteDto updateQuote(@PathVariable UUID quoteId, @RequestBody QuoteInputDto quoteInputDto);

  @Operation(security = {@SecurityRequirement(name = "bearer-key")})
  @DeleteMapping("/{quoteId}")
  void deleteQuote(@PathVariable UUID quoteId);
}
