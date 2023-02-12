package com.example.kameleoon.service.logic;

import com.example.kameleoon.service.model.auth.TokenResponse;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.auth.UserRegisterDto;
import com.example.kameleoon.service.validation.group.NotFoundGroup;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;

@Validated({Default.class, NotFoundGroup.class})
public interface AuthService {

  TokenResponse registerUser(
    @NotNull
    @Valid
    UserRegisterDto userRegisterDto
  );

  TokenResponse authUser(
    @NotNull
    @Valid
    UserAuthDto userAuthDto
  );
}
