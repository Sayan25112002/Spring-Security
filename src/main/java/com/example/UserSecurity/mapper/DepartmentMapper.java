package com.example.UserSecurity.mapper;

import com.example.UserSecurity.dto.requestDto.DepartmentRequestDto;
import com.example.UserSecurity.dto.responseDto.DepartmentResponseDto;
import com.example.UserSecurity.entity.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department toDepartment(DepartmentRequestDto departmentRequestDto);

    DepartmentResponseDto toDepartmentResponseDto(Department department);

    List<DepartmentResponseDto> toDepartmentResponseDto(List<Department> departments);

}
