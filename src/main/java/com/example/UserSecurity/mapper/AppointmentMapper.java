package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.AppointmentRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;
import com.example.UserSecurity.entity.Appointment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    Appointment toAppointment(AppointmentRequestDto appointmentRequestDto);

    AppointmentResponseDto toAppointmentResponseDto(Appointment appointment);

    List<AppointmentResponseDto> toAppointmentResponseDtos(List<Appointment> appointments);

}
