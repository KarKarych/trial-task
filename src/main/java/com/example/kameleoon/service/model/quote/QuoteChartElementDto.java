package com.example.kameleoon.service.model.quote;

import java.time.LocalDate;


public record QuoteChartElementDto(
  LocalDate date,
  Integer upvoteCount,
  Integer downvoteCount
) {
}
