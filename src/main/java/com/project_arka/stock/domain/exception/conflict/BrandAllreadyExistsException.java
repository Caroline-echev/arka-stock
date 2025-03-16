package com.project_arka.stock.domain.exception.conflict;

public class BrandAllreadyExistsException extends RuntimeException {
    public BrandAllreadyExistsException(String message) {
        super(message);
    }
}
