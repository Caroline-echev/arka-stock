package com.project_arka.stock.domain.exception.badrequest;

public class CategoryInvalidException extends RuntimeException {
    public CategoryInvalidException(String message) {
        super(message);
    }
}
