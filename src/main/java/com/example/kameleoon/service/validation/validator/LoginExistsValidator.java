package com.example.kameleoon.service.validation.validator;

import com.example.kameleoon.persistence.repository.UserRepository;
import com.example.kameleoon.service.validation.constraint.LoginExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class LoginExistsValidator implements ConstraintValidator<LoginExists, String> {

  private final UserRepository userRepository;

  @Override
  public boolean isValid(String login, ConstraintValidatorContext context) {
    if (login == null) {
      return true;
    }

    return userRepository.existsByLogin(login);
  }
}
