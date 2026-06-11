package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.PatientRequestDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toPatient(PatientRequestDto patientRequestDto);

    @Mapping(source = "insurance",target = "insuranceResponseDto")
    @Mapping(source = "appointments",target = "appointmentResponseDtos")
    PatientResponseDto toPatientResponseDto(Patient patient);

    @Mapping(source = "insurance",target = "insuranceResponseDto")
    @Mapping(source = "appointments",target = "appointmentResponseDtos")
    List<PatientResponseDto> toPatientResponseDtos(List<Patient> patients);

}
