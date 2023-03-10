package com.example.kameleoon.service.logic;

import com.example.kameleoon.service.model.PageDto;
import com.example.kameleoon.service.model.quote.QuoteDto;
import com.example.kameleoon.service.model.quote.QuoteInputDto;
import com.example.kameleoon.service.validation.constraint.QuoteIdExists;
import com.example.kameleoon.service.validation.constraint.UserIdExists;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated({Default.class, NotFoundGroup.class})
public interface QuoteService {

  QuoteDto getRandomQuote();

  List<QuoteDto> getTop10Quotes();

  List<QuoteDto> getFlop10Quotes();

  PageDto<QuoteDto> getLastQuotes(
    @NotNull
    Integer pageNumber,
    @NotNull
    Integer pageSize
  );

  PageDto<QuoteDto> getLastQuotesByUser(
    @NotNull
    @UserIdExists(groups = NotFoundGroup.class)
    UUID userId,
    @NotNull
    Integer pageNumber,
    @NotNull
    Integer pageSize
  );

  QuoteDto saveQuote(
    @NotNull
    @UserIdExists(groups = NotFoundGroup.class)
    UUID userId,
    @Valid
    QuoteInputDto quoteInputDto
  );

  QuoteDto updateQuote(
    @NotNull
    @UserIdExists(groups = NotFoundGroup.class)
    UUID userId,
    @NotNull
    @QuoteIdExists(groups = NotFoundGroup.class)
    UUID quoteId,
    @Valid
    QuoteInputDto quoteInputDto
  );

  void deleteQuote(
    @NotNull
    @UserIdExists(groups = NotFoundGroup.class)
    UUID userId,
    @NotNull
    @QuoteIdExists(groups = NotFoundGroup.class)
    UUID quoteId
  );
}
