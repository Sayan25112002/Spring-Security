package com.example.UserSecurity.controller;

import com.example.UserSecurity.dto.requestDto.AppointmentRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;
import com.example.UserSecurity.entity.Appointment;
import com.example.UserSecurity.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/createAppointment/{doctorId}/{patientId}")
    public AppointmentResponseDto createAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto, @PathVariable Long doctorId, @PathVariable Long patientId){
        return appointmentService.createNewAppointment(appointmentRequestDto, doctorId, patientId);
    }

    @GetMapping("/getAppointment/{appointmentId}/{doctorId}")
    public AppointmentResponseDto reAssignAppointmentToAnotherDoctor(@PathVariable Long appointmentId, @PathVariable Long doctorId){
        return appointmentService.reAssignAppointmentToAnotherDoctor(appointmentId, doctorId);
    }
}
