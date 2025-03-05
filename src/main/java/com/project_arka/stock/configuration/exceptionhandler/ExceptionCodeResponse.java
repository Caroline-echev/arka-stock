package com.project_arka.stock.configuration.exceptionhandler;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class ExceptionCodeResponse {
    private final int code;
    private final String message;
    private final String status;
    private final LocalDateTime timestamp;
}
