package com.example.UserSecurity.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponseDto {

    private Long id;

    private LocalDateTime localDateTime;

    private String reason;

    private PatientResponseDto patientResponseDto;

    private DoctorResponseDto doctorResponseDto;

}
