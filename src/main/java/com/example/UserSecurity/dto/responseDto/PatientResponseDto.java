package com.example.UserSecurity.dto.responseDto;

import com.example.UserSecurity.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private LocalDateTime createdAt;

    private BloodGroupType bloodGroupType;

    private InsuranceResponseDto insuranceResponseDto;

    private List<AppointmentResponseDto> appointmentResponseDtos;

}
