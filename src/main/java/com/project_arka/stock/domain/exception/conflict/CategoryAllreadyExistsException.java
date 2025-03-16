package com.project_arka.stock.domain.exception.conflict;

public class CategoryAllreadyExistsException extends RuntimeException {
    public CategoryAllreadyExistsException(String message) {
        super(message);
    }
}
