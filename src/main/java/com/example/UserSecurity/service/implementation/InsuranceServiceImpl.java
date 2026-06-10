package com.example.UserSecurity.service.implementation;

import com.example.UserSecurity.dto.requestDto.InsuranceRequestDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Insurance;
import com.example.UserSecurity.entity.Patient;
import com.example.UserSecurity.mapper.InsuranceMapper;
import com.example.UserSecurity.mapper.PatientMapper;
import com.example.UserSecurity.repository.InsuranceRepository;
import com.example.UserSecurity.repository.PatientRepository;
import com.example.UserSecurity.service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    private final InsuranceMapper insuranceMapper;
    private final PatientMapper patientMapper;

    @Override
    @Transactional
    public PatientResponseDto assignInsuranceToPatient(InsuranceRequestDto insuranceRequestDto, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id: " + patientId + " not found"));
        Insurance insurance = insuranceMapper.toInsurance(insuranceRequestDto);
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        PatientResponseDto patientResponseDto = patientMapper.toPatientResponseDto(patient);
        return patientResponseDto;
    }


}
