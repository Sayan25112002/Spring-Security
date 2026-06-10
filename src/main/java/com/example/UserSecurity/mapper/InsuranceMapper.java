package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.InsuranceRequestDto;
import com.example.UserSecurity.dto.responseDto.InsuranceResponseDto;
import com.example.UserSecurity.entity.Insurance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    Insurance toInsurance(InsuranceRequestDto insuranceRequestDto);

    InsuranceResponseDto toInsuranceResponseDto(Insurance insurance);

    List<InsuranceResponseDto> toInsuranceResponseDto(List<Insurance> insurances);

}
