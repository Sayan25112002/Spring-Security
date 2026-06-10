package com.example.UserSecurity.service.implementation;

import com.example.UserSecurity.dto.requestDto.AppointmentRequestDto;
import com.example.UserSecurity.dto.responseDto.AppointmentResponseDto;
import com.example.UserSecurity.entity.Appointment;
import com.example.UserSecurity.entity.Doctor;
import com.example.UserSecurity.entity.Patient;
import com.example.UserSecurity.mapper.AppointmentMapper;
import com.example.UserSecurity.mapper.DoctorMapper;
import com.example.UserSecurity.mapper.PatientMapper;
import com.example.UserSecurity.repository.AppointmentRepository;
import com.example.UserSecurity.repository.DoctorRepository;
import com.example.UserSecurity.repository.PatientRepository;
import com.example.UserSecurity.service.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final AppointmentMapper appointmentMapper;
    private final DoctorMapper doctorMapper;
    private final PatientMapper patientMapper;

    @Override
    @Transactional
    public AppointmentResponseDto createNewAppointment(AppointmentRequestDto appointmentRequestDto, Long doctorId, Long patientId) {
        Appointment appointment = appointmentMapper.toAppointment(appointmentRequestDto);
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor with id: " + doctorId + " not found"));
        Patient patient = patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient with id: " + patientId + " not found"));
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        doctor.getAppointments().add(appointment);
        patient.getAppointments().add(appointment);
        appointmentRepository.save(appointment);
        return appointmentMapper.toAppointmentResponseDto(appointment);
    }

    @Override
    @Transactional
    public AppointmentResponseDto reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()-> new EntityNotFoundException("Appointments with id: " + appointmentId + " not found"));
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(()-> new EntityNotFoundException("Doctor with id: " + doctorId + " not found"));
        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        return appointmentMapper.toAppointmentResponseDto(appointmentRepository.save(appointment));
    }
}
