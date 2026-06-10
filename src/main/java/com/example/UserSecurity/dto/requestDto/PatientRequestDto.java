package com.example.UserSecurity.dto.requestDto;

import com.example.UserSecurity.entity.type.BloodGroupType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDto {

    private String name;

    private LocalDate birthDate;

    private String email;

    private LocalDateTime createdAt;

    private BloodGroupType bloodGroupType;

}
