package com.example.kameleoon.service.exception.handler;


import com.example.kameleoon.service.exception.ApiException;
import com.example.kameleoon.service.exception.model.Error;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.groups.Default;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<Error> handleModelException(ApiException ae) {
    return ResponseEntity
      .status(ae.getStatus())
      .body(new Error(ae.getMessage()));
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<Error> handleHttpMessageNotReadableException() {
    return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(new Error("Invalid input value"));
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Error> handleMethodArgumentTypeMismatchException() {
    return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(new Error("Invalid input value"));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Error> handleConstraintViolationException(ConstraintViolationException cve) {
    String message = cve.getConstraintViolations().stream()
      .filter(e -> e.getConstraintDescriptor().getGroups().contains(NotFoundGroup.class))
      .map(cv -> cv.getInvalidValue() + " - " + cv.getMessage())
      .collect(Collectors.joining("; "));

    if (!message.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error(message));
    }

    message = cve.getConstraintViolations().stream()
      .filter(e -> e.getConstraintDescriptor().getGroups().contains(Default.class))
      .map(cv -> cv.getInvalidValue() + " - " + cv.getMessage())
      .collect(Collectors.joining("; "));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Error(message));
  }
}
