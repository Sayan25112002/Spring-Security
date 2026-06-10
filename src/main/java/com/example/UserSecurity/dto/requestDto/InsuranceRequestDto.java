package com.example.UserSecurity.dto.requestDto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceRequestDto {

    private String policyNumber;

    private String provider;

    private LocalDate validUntil;

}
