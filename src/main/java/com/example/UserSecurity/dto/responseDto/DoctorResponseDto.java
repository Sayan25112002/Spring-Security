package com.example.UserSecurity.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponseDto {

    private Long id;

    private String name;

    private String specialization;

    private String email;

    private Set<DepartmentResponseDto> departmentResponseDtos;

    private List<AppointmentResponseDto> appointmentResponseDtos;

}
