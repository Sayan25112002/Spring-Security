package com.example.UserSecurity.service.implementation;

import com.example.UserSecurity.dto.requestDto.PatientRequestDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Insurance;
import com.example.UserSecurity.entity.Patient;
import com.example.UserSecurity.mapper.PatientMapper;
import com.example.UserSecurity.repository.AppointmentRepository;
import com.example.UserSecurity.repository.InsuranceRepository;
import com.example.UserSecurity.repository.PatientRepository;
import com.example.UserSecurity.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final InsuranceRepository insuranceRepository;

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        Patient patient = patientMapper.toPatient(patientRequestDto);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toPatientResponseDto(savedPatient);
    }

    @Override
    public List<PatientResponseDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patientMapper.toPatientResponseDtos(patients);
    }
}
