package com.project_arka.stock.domain.exception;

public class EmptyBrandListException extends RuntimeException{
    public EmptyBrandListException(String message) {
        super(message);
    }
}
