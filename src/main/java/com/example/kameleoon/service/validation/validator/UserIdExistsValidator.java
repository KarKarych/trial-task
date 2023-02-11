package com.example.kameleoon.service.validation.validator;

import com.example.kameleoon.persistence.repository.UserRepository;
import com.example.kameleoon.service.validation.constraint.UserIdExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@RequiredArgsConstructor
public class UserIdExistsValidator implements ConstraintValidator<UserIdExists, UUID> {

  private final UserRepository userRepository;

  @Override
  public boolean isValid(UUID id, ConstraintValidatorContext context) {
    if (id == null) {
      return true;
    }

    return userRepository.existsById(id);
  }
}
