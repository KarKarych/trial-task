package com.example.kameleoon.service.model.quote;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record QuoteInputDto(
  @NotBlank
  @Size(min = 16, max = 1024)
  String content
) {
}
