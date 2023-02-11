package com.example.kameleoon.service.validation.validator;

import com.example.kameleoon.persistence.repository.QuoteRepository;
import com.example.kameleoon.service.validation.constraint.QuoteIdDoesNotExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@RequiredArgsConstructor
public class QuoteIdDoesNotExistValidator implements ConstraintValidator<QuoteIdDoesNotExist, UUID> {

  private final QuoteRepository quoteRepository;

  @Override
  public boolean isValid(UUID id, ConstraintValidatorContext context) {
    if (id == null) {
      return true;
    }

    return !quoteRepository.existsById(id);
  }
}
