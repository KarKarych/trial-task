package com.example.kameleoon.security;

import com.example.kameleoon.persistence.entity.User;
import com.example.kameleoon.service.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SecurityService {

  public UUID getId() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Object principal = securityContext.getAuthentication().getPrincipal();
    if (principal instanceof User user) {
      return user.getId();
    } else {
      throw new ApiException("Unauthorized access, invalid credentials", HttpStatus.FORBIDDEN);
    }
  }
}
