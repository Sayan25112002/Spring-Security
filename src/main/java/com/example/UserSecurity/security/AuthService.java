package com.example.UserSecurity.security;

import com.example.UserSecurity.dto.requestDto.LoginRequestDto;
import com.example.UserSecurity.dto.responseDto.LoginResponseDto;
import com.example.UserSecurity.dto.responseDto.SignupResponseDto;
import com.example.UserSecurity.entity.User;
import com.example.UserSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUserName(), loginRequestDto.getPassword())
        );
        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateAccessToken(user);
        return new LoginResponseDto(user.getId(),token);
    }

    public SignupResponseDto signup(LoginRequestDto signupRequestDto) {
        User user = userRepository.findByUsername(signupRequestDto.getUserName()).orElse(null);
        if (user!=null){
            throw new IllegalArgumentException("User already exists. Please Login");
        }
        user=userRepository.save(User.builder()
                .username(signupRequestDto.getUserName())
                .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                .build()
        );
        return new SignupResponseDto(user.getId(),user.getUsername());
    }
}
