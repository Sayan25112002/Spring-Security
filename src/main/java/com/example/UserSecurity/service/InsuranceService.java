package com.example.UserSecurity.service;

import com.example.UserSecurity.dto.requestDto.InsuranceRequestDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;

public interface InsuranceService {

    PatientResponseDto assignInsuranceToPatient(InsuranceRequestDto insuranceRequestDto, Long patientId);
}
