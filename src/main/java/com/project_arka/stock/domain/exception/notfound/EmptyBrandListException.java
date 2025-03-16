package com.project_arka.stock.domain.exception.notfound;

public class EmptyBrandListException extends RuntimeException{
    public EmptyBrandListException(String message) {
        super(message);
    }
}
