package com.example.UserSecurity.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDto {

    private Long id;

    private String name;

    private DoctorResponseDto headDoctorResponseDto;

    private Set<DoctorResponseDto> doctorResponseDtos;

}
