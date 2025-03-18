package com.project_arka.stock.domain.exception.notfound;

public class EmptyCategoryListException extends RuntimeException {
    public EmptyCategoryListException(String message) {
        super(message);
    }
}
