package com.example.UserSecurity.controller;

import com.example.UserSecurity.dto.requestDto.PatientRequestDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Patient;
import com.example.UserSecurity.repository.PatientRepository;
import com.example.UserSecurity.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/createPatient")
    public PatientResponseDto createPatient(@RequestBody PatientRequestDto patientRequestDto) {
        return patientService.createPatient(patientRequestDto);
    }

    @GetMapping("/getAllPatients")
    public List<PatientResponseDto> getAllPatients() {
        return patientService.getAllPatients();
    }

}
