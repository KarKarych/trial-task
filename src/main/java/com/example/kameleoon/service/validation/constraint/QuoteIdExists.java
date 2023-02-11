package com.example.kameleoon.service.validation.constraint;

import com.example.kameleoon.service.validation.validator.QuoteIdExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = QuoteIdExistsValidator.class)
public @interface QuoteIdExists {

  String message() default "quoteId not found";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
