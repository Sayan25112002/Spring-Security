package com.example.UserSecurity.controller;

import com.example.UserSecurity.dto.requestDto.DoctorRequestDto;
import com.example.UserSecurity.dto.responseDto.DoctorResponseDto;
import com.example.UserSecurity.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/getDoctor")
    public List<DoctorResponseDto> getDoctor(@RequestBody DoctorRequestDto doctorRequestDto){
        return doctorService.getAllDoctors();
    }

    @PostMapping("/createDoctor")
    public DoctorResponseDto createDoctor(@RequestBody DoctorRequestDto doctorRequestDto){
        return doctorService.createDoctor(doctorRequestDto);
    }
}
