package com.example.kameleoon.service.logic;

import com.example.kameleoon.service.model.auth.TokenResponse;
import com.example.kameleoon.service.model.auth.UserAuthDto;
import com.example.kameleoon.service.model.auth.UserRegisterDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface AuthService {

  TokenResponse registerUser(@NotNull @Valid UserRegisterDto userRegisterDto);

  TokenResponse authUser(@NotNull @Valid UserAuthDto userAuthDto);
}
