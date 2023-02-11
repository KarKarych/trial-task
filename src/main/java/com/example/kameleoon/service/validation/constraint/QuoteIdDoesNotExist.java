package com.example.kameleoon.service.validation.constraint;

import com.example.kameleoon.service.validation.validator.QuoteIdDoesNotExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuoteIdDoesNotExistValidator.class)
public @interface QuoteIdDoesNotExist {

  String message() default "quoteId already exists";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
