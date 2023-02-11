package com.example.kameleoon.service.validation.constraint;

import com.example.kameleoon.service.validation.validator.LoginDoesNotExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginDoesNotExistValidator.class)
public @interface LoginDoesNotExist {

  String message() default "login already exists";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
