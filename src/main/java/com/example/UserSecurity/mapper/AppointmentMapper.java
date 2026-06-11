package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.AppointmentRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;
import com.example.UserSecurity.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    Appointment toAppointment(AppointmentRequestDto appointmentRequestDto);

    @Mapping(target = "patientResponseDto",  source="patient")
    @Mapping(target = "doctorResponseDto", source="doctor")
    AppointmentResponseDto toAppointmentResponseDto(Appointment appointment);

    @Mapping(target = "patientResponseDto",  source="patient")
    @Mapping(target = "doctorResponseDto", source="doctor")
    List<AppointmentResponseDto> toAppointmentResponseDtos(List<Appointment> appointments);

}
