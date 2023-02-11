package com.example.kameleoon.service.validation.constraint;

import com.example.kameleoon.service.validation.validator.UserIdExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserIdExistsValidator.class)
public @interface UserIdExists {

  String message() default "userId not found";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
