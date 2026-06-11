package com.example.UserSecurity.service;

import com.example.UserSecurity.dto.requestDto.InsuranceRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;
import com.example.UserSecurity.dto.responseDto.InsuranceResponseDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;

import java.util.List;

public interface InsuranceService {

    InsuranceResponseDto createInsurance(InsuranceRequestDto insuranceRequestDto, Long patientId);

    List<InsuranceResponseDto> getAllInsurances();

    PatientResponseDto assignInsuranceToPatient(Long insuranceId, Long patientId);

    PatientResponseDto dissociateInsuranceFromPatient(Long patientId);

    List<AppointmentResponseDto> getThreeAppointments(Long doctorId, Long patientId);

    void deletePatient(Long patientId);

}
