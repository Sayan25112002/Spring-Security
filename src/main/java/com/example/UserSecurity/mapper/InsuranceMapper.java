package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.InsuranceRequestDto;
import com.example.UserSecurity.dto.responseDto.InsuranceResponseDto;
import com.example.UserSecurity.entity.Insurance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    Insurance toInsurance(InsuranceRequestDto insuranceRequestDto);

    @Mapping(source = "patient", target = "patientResponseDto")
    InsuranceResponseDto toInsuranceResponseDto(Insurance insurance);

    @Mapping(source = "patient", target = "patientResponseDto")
    List<InsuranceResponseDto> toInsuranceResponseDto(List<Insurance> insurances);

}
