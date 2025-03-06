package com.project_arka.stock.configuration.exceptionhandler;

import com.project_arka.stock.domain.exception.BrandAllreadyExistsException;
import com.project_arka.stock.domain.exception.BrandInvalidException;
import com.project_arka.stock.domain.exception.BrandNotFoundException;
import com.project_arka.stock.domain.exception.EmptyBrandListException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionCodeResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getFieldErrors().get(0);
        return ResponseEntity.badRequest().body(new ExceptionCodeResponse(HttpStatus.BAD_REQUEST.value(), fieldError.getDefaultMessage(), HttpStatus.BAD_REQUEST.name(), LocalDateTime.now()));
    }
    @ExceptionHandler(BrandAllreadyExistsException.class)
    public ResponseEntity<ExceptionCodeResponse> handleBrandAllreadyExistsException(BrandAllreadyExistsException ex) {
        return ResponseEntity.badRequest().body(new ExceptionCodeResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), HttpStatus.BAD_REQUEST.name(), LocalDateTime.now()));
    }
    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<ExceptionCodeResponse> handleBrandNotFoundException(BrandNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionCodeResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), HttpStatus.NOT_FOUND.name(), LocalDateTime.now())
        );
    }
    @ExceptionHandler(BrandInvalidException.class)
    public ResponseEntity<ExceptionCodeResponse> handleBrandInvalidException(BrandInvalidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionCodeResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), HttpStatus.BAD_REQUEST.name(), LocalDateTime.now())
        );
    }
    @ExceptionHandler(EmptyBrandListException.class)
    public ResponseEntity<ExceptionCodeResponse> handleEmptyBrandListException(EmptyBrandListException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionCodeResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), HttpStatus.NOT_FOUND.name(), LocalDateTime.now())
        );
    }
}
