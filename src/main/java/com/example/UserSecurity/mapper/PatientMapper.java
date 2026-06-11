package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.PatientRequestDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto toPatientResponseDto(Patient patient);

    List<PatientResponseDto> toPatientResponseDtos(List<Patient> patients);

}
