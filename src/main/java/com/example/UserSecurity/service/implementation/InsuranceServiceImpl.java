package com.example.UserSecurity.service.implementation;

import com.example.UserSecurity.dto.requestDto.AppointmentRequestDto;
import com.example.UserSecurity.dto.requestDto.InsuranceRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;
import com.example.UserSecurity.dto.responseDto.InsuranceResponseDto;
import com.example.UserSecurity.dto.responseDto.PatientResponseDto;
import com.example.UserSecurity.entity.Appointment;
import com.example.UserSecurity.entity.Doctor;
import com.example.UserSecurity.entity.Insurance;
import com.example.UserSecurity.entity.Patient;
import com.example.UserSecurity.mapper.AppointmentMapper;
import com.example.UserSecurity.mapper.InsuranceMapper;
import com.example.UserSecurity.mapper.PatientMapper;
import com.example.UserSecurity.repository.AppointmentRepository;
import com.example.UserSecurity.repository.DoctorRepository;
import com.example.UserSecurity.repository.InsuranceRepository;
import com.example.UserSecurity.repository.PatientRepository;
import com.example.UserSecurity.service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    private final InsuranceMapper insuranceMapper;
    private final PatientMapper patientMapper;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    @Override
    public InsuranceResponseDto createInsurance(InsuranceRequestDto insuranceRequestDto, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient Not Found"));
        Insurance insurance = insuranceMapper.toInsurance(insuranceRequestDto);
        insurance.setPatient(patient);
        patient.setInsurance(insurance);
        Patient savedPatient = patientRepository.save(patient);
        Insurance savedInsurance = savedPatient.getInsurance();
        return insuranceMapper.toInsuranceResponseDto(savedInsurance);
    }

    @Override
    public List<InsuranceResponseDto> getAllInsurances() {
        return insuranceMapper.toInsuranceResponseDto(insuranceRepository.findAll());
    }

    @Override
    public PatientResponseDto assignInsuranceToPatient(Long insuranceId, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id: " + patientId + " not found"));
        Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(()-> new EntityNotFoundException("Insurance with id: " + insuranceId + " not found"));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        Patient savedPatient = patientRepository.save(patient);
        PatientResponseDto patientResponseDto = patientMapper.toPatientResponseDto(savedPatient);
        return patientResponseDto;
    }

    @Override
    public PatientResponseDto dissociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id: " + patientId + " not found"));
        patient.setInsurance(null);
        Patient savedPatient = patientRepository.save(patient);
        PatientResponseDto patientResponseDto = patientMapper.toPatientResponseDto(savedPatient);
        return patientResponseDto;
    }

    @Override
    public List<AppointmentResponseDto> getThreeAppointments(Long doctorId, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id: " + patientId + " not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor with id: " + doctorId + " not found"));
        AppointmentRequestDto appointmentRequestDto1 = AppointmentRequestDto.builder()
                .reason("Reason 1")
                .appointmentTime(LocalDateTime.of(2026,6,25,12,0))
                .build();
        AppointmentRequestDto appointmentRequestDto2 = AppointmentRequestDto.builder()
                .reason("Reason 2")
                .appointmentTime(LocalDateTime.of(2026,6,25,12,0))
                .build();
        AppointmentRequestDto appointmentRequestDto3 = AppointmentRequestDto.builder()
                .reason("Reason 3")
                .appointmentTime(LocalDateTime.of(2026,6,25,12,0 ))
                .build();
        Appointment appointment1 = appointmentMapper.toAppointment(appointmentRequestDto1);
        appointment1.setPatient(patient);
        appointment1.setDoctor(doctor);
        Appointment appointment2 = appointmentMapper.toAppointment(appointmentRequestDto2);
        appointment2.setPatient(patient);
        appointment2.setDoctor(doctor);
        Appointment appointment3 = appointmentMapper.toAppointment(appointmentRequestDto3);
        appointment3.setPatient(patient);
        appointment3.setDoctor(doctor);
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(appointment1);
        appointments.add(appointment2);
        appointments.add(appointment3);
        List<Appointment> savedAppointments = appointmentRepository.saveAll(appointments);
        return appointmentMapper.toAppointmentResponseDtos(savedAppointments);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id: " + patientId + " not found"));
        patientRepository.delete(patient);
    }
}
