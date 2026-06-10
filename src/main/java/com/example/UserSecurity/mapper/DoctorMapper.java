package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.DoctorRequestDto;
import com.example.UserSecurity.dto.responseDto.DoctorResponseDto;
import com.example.UserSecurity.entity.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toDoctor(DoctorRequestDto doctorRequestDto);

    DoctorResponseDto toDoctorResponseDto(Doctor doctor);

    List<DoctorResponseDto> toDoctorResponseDto(List<Doctor> doctors);

}
