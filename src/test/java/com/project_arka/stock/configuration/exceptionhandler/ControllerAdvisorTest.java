package com.project_arka.stock.configuration.exceptionhandler;

import com.project_arka.stock.domain.exception.badrequest.BrandInvalidException;
import com.project_arka.stock.domain.exception.badrequest.CategoryInvalidException;
import com.project_arka.stock.domain.exception.conflict.BrandAllreadyExistsException;
import com.project_arka.stock.domain.exception.conflict.CategoryAllreadyExistsException;
import com.project_arka.stock.domain.exception.notfound.BrandNotFoundException;
import com.project_arka.stock.domain.exception.notfound.CategoryNotFoundException;
import com.project_arka.stock.domain.exception.notfound.EmptyBrandListException;
import com.project_arka.stock.domain.exception.notfound.EmptyCategoryListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ControllerAdvisorTest {

    private ControllerAdvisor controllerAdvisor;

    @BeforeEach
    void setUp() {
        controllerAdvisor = new ControllerAdvisor();
    }

    @Test
    void handleMethodArgumentNotValidException() {
        FieldError fieldError = mock(FieldError.class);
        when(fieldError.getDefaultMessage()).thenReturn("Invalid field");
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        when(exception.getFieldErrors()).thenReturn(List.of(fieldError));

        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleMethodArgumentNotValidException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid field", response.getBody().getMessage());
    }
    @Test
    void handleBrandAllreadyExistsException() {
        BrandAllreadyExistsException exception = new BrandAllreadyExistsException("Brand already exists");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleBrandAllreadyExistsException(exception);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Brand already exists", response.getBody().getMessage());
    }

    @Test
    void handleBrandNotFoundException() {
        BrandNotFoundException exception = new BrandNotFoundException("Brand not found");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleBrandNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Brand not found", response.getBody().getMessage());
    }

    @Test
    void handleBrandInvalidException() {
        BrandInvalidException exception = new BrandInvalidException("Invalid brand");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleBrandInvalidException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid brand", response.getBody().getMessage());
    }

    @Test
    void handleEmptyBrandListException() {
        EmptyBrandListException exception = new EmptyBrandListException("No brands found");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleEmptyBrandListException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No brands found", response.getBody().getMessage());
    }

    @Test
    void handleCategoryInvalidException() {
        CategoryInvalidException exception = new CategoryInvalidException("Invalid category");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleCategoryInvalidException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid category", response.getBody().getMessage());
    }

    @Test
    void handleEmptyCategoryListException() {
        EmptyCategoryListException exception = new EmptyCategoryListException("No categories found");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleEmptyCategoryListException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No categories found", response.getBody().getMessage());
    }

    @Test
    void handleCategoryAllreadyExistsException() {
        CategoryAllreadyExistsException exception = new CategoryAllreadyExistsException("Category already exists");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleCategoryAllreadyExistsException(exception);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals("Category already exists", response.getBody().getMessage());
    }

    @Test
    void handleCategoryNotFoundException() {
        CategoryNotFoundException exception = new CategoryNotFoundException("Category not found");
        ResponseEntity<ExceptionCodeResponse> response = controllerAdvisor.handleCategoryNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Category not found", response.getBody().getMessage());
    }
}