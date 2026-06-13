package com.example.UserSecurity.controller;

import com.example.UserSecurity.dto.requestDto.LoginRequestDto;
import com.example.UserSecurity.dto.responseDto.LoginResponseDto;
import com.example.UserSecurity.dto.responseDto.SignupResponseDto;
import com.example.UserSecurity.repository.UserRepository;
import com.example.UserSecurity.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }

    @PostMapping("/signup")
    public SignupResponseDto signup(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.signup(loginRequestDto);
    }
}
