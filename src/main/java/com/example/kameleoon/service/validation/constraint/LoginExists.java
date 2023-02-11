package com.example.kameleoon.service.validation.constraint;

import com.example.kameleoon.service.validation.validator.LoginExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginExistsValidator.class)
public @interface LoginExists {

  String message() default "login not found";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
