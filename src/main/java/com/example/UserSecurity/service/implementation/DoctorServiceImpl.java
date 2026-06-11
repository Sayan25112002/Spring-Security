package com.example.UserSecurity.service.implementation;

import com.example.UserSecurity.dto.requestDto.DoctorRequestDto;
import com.example.UserSecurity.dto.responseDto.DoctorResponseDto;
import com.example.UserSecurity.entity.Doctor;
import com.example.UserSecurity.mapper.DoctorMapper;
import com.example.UserSecurity.repository.DoctorRepository;
import com.example.UserSecurity.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponseDto createDoctor(DoctorRequestDto doctorRequestDto) {
        Doctor doctor = doctorMapper.toDoctor(doctorRequestDto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDoctorResponseDto(savedDoctor);
    }

    @Override
    public List<DoctorResponseDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.toDoctorResponseDto(doctors);
    }
}
