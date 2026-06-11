package com.example.UserSecurity.service;

import com.example.UserSecurity.dto.requestDto.DoctorRequestDto;
import com.example.UserSecurity.dto.responseDto.DoctorResponseDto;

import java.util.List;

public interface DoctorService {

    DoctorResponseDto createDoctor(DoctorRequestDto doctorRequestDto);

    List<DoctorResponseDto> getAllDoctors();

}
