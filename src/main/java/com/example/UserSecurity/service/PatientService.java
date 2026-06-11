package com.example.UserSecurity.service;

import com.example.UserSecurity.dto.requestDto.PatientRequestDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Patient;

import java.util.List;

public interface PatientService {

    PatientResponseDto createPatient(PatientRequestDto patientRequestDto);

    List<PatientResponseDto> getAllPatients();

}
