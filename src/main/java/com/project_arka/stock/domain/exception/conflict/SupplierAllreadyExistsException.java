package com.project_arka.stock.domain.exception.conflict;

public class SupplierAllreadyExistsException extends RuntimeException {

    public SupplierAllreadyExistsException(String message) {
        super(message);
    }
}
