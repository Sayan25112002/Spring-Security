package com.example.UserSecurity.service;

import com.example.UserSecurity.dto.requestDto.AppointmentRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;

public interface AppointmentService {

    AppointmentResponseDto createNewAppointment(AppointmentRequestDto appointmentRequestDto, Long doctorId, Long patientId);

    AppointmentResponseDto reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId);

}
