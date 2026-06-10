package com.example.UserSecurity.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsuranceResponseDto {

    private Long id;

    private String policyNumber;

    private String provider;

    private LocalDate validUntil;

    private LocalDateTime createdAt;

    private PatientResponseDto patientResponseDto;

}
