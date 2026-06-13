package com.example.UserSecurity.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class ApiError {

    private LocalDate timestamp;
    private String errorMessage;
    private HttpStatus httpStatus;

    public ApiError() {
        this.timestamp=LocalDate.now();
    }

    public ApiError(String errorMessage,HttpStatus httpStatus) {
        this();
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }
}
