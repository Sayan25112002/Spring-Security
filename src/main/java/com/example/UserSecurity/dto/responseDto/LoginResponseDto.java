package com.example.UserSecurity.dto.responseDto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    private Long userId;

    private String jwt;

}
