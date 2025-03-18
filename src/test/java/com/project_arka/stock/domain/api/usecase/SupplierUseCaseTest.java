package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.data.SupplierData;
import com.project_arka.stock.domain.exception.conflict.SupplierAllreadyExistsException;
import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.domain.spi.ISupplierPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.project_arka.stock.domain.util.DomainConstants.SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplierUseCaseTest {

    @Mock
    private ISupplierPersistencePort supplierPersistencePort;

    @InjectMocks
    private SupplierUseCase supplierUseCase;

    private Supplier supplier;

    @BeforeEach
    void setUp() {
        supplier = SupplierData.getSupplier();
    }

    @Test
    void createSupplier_shouldSaveSupplier_whenNoConflict() {
        when(supplierPersistencePort.findByName(supplier.getName())).thenReturn(null);
        when(supplierPersistencePort.findByEmail(supplier.getEmail())).thenReturn(null);
        when(supplierPersistencePort.findByNit(supplier.getNit())).thenReturn(null);
        when(supplierPersistencePort.saveSupplier(supplier)).thenReturn(supplier);

        Supplier result = supplierUseCase.createSupplier(supplier);

        assertNotNull(result);
        assertEquals(supplier.getName(), result.getName());
        verify(supplierPersistencePort).saveSupplier(supplier);
    }

    @Test
    void createSupplier_shouldThrowException_whenNameExists() {
        when(supplierPersistencePort.findByName(supplier.getName())).thenReturn(supplier);

        SupplierAllreadyExistsException exception = assertThrows(SupplierAllreadyExistsException.class, () ->
                supplierUseCase.createSupplier(supplier)
        );

        assertEquals(SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE, exception.getMessage());
        verify(supplierPersistencePort, never()).saveSupplier(any());
    }

    @Test
    void createSupplier_shouldThrowException_whenEmailExists() {
        when(supplierPersistencePort.findByName(supplier.getName())).thenReturn(null);
        when(supplierPersistencePort.findByEmail(supplier.getEmail())).thenReturn(supplier);

        SupplierAllreadyExistsException exception = assertThrows(SupplierAllreadyExistsException.class, () ->
                supplierUseCase.createSupplier(supplier)
        );

        assertEquals(SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE, exception.getMessage());
        verify(supplierPersistencePort, never()).saveSupplier(any());
    }

    @Test
    void createSupplier_shouldThrowException_whenNitExists() {
        when(supplierPersistencePort.findByName(supplier.getName())).thenReturn(null);
        when(supplierPersistencePort.findByEmail(supplier.getEmail())).thenReturn(null);
        when(supplierPersistencePort.findByNit(supplier.getNit())).thenReturn(supplier);

        SupplierAllreadyExistsException exception = assertThrows(SupplierAllreadyExistsException.class, () ->
                supplierUseCase.createSupplier(supplier)
        );

        assertEquals(SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE, exception.getMessage());
        verify(supplierPersistencePort, never()).saveSupplier(any());
    }
}
