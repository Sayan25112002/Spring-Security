package com.example.UserSecurity.controller;

import com.example.UserSecurity.dto.requestDto.InsuranceRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;
import com.example.UserSecurity.dto.responseDto.InsuranceResponseDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Appointment;
import com.example.UserSecurity.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/createInsurance/{patientId}")
    public InsuranceResponseDto createInsurance(@RequestBody InsuranceRequestDto insuranceRequestDto,@PathVariable Long patientId) {
        return insuranceService.createInsurance(insuranceRequestDto,patientId);
    }

    @GetMapping("/getInsurance")
    public List<InsuranceResponseDto> getInsurance() {
        return insuranceService.getAllInsurances();
    }

    @GetMapping("/assignInsuranceToPatient/{insuranceId}/{patientId}")
    public PatientResponseDto assignInsuranceToPatient(@PathVariable Long insuranceId, @PathVariable Long patientId) {
        return insuranceService.assignInsuranceToPatient(insuranceId, patientId);
    }

    @GetMapping("/dissociateInsuranceFromPatient/{patientId}")
    public PatientResponseDto dissociateInsuranceFromPatient(@PathVariable Long patientId) {
        return insuranceService.dissociateInsuranceFromPatient(patientId);
    }

    @GetMapping("/getThreeAppointments/{doctorId}/{patientId}")
    public List<AppointmentResponseDto> getThreeAppointments(@PathVariable Long doctorId, @PathVariable Long patientId) {
        return insuranceService.getThreeAppointments(doctorId,patientId);
    }

    @DeleteMapping("/deletePatient/{patientId}")
    public void deletePatient(@PathVariable Long patientId) {
        insuranceService.deletePatient(patientId);
    }
}
