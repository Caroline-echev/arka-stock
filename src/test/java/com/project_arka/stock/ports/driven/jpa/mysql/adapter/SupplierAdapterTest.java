package com.project_arka.stock.ports.driven.jpa.mysql.adapter;
import com.project_arka.stock.data.SupplierData;
import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.SupplierEntity;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.ISupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplierAdapterTest {

    @Mock
    private ISupplierRepository supplierRepository;

    @Mock
    private ISupplierEntityMapper supplierEntityMapper;

    @InjectMocks
    private SupplierAdapter supplierAdapter;

    private Supplier supplier;
    private SupplierEntity supplierEntity;

    @BeforeEach
    void setUp() {
        supplier = SupplierData.getSupplier();
        supplierEntity = SupplierData.getSupplierEntity();

    }

    @Test
    void findByName_shouldReturnSupplier() {
        when(supplierRepository.findByName("Tech Solutions S.A.S")).thenReturn(supplierEntity);
        when(supplierEntityMapper.supplierEntityToSupplier(supplierEntity)).thenReturn(supplier);

        Supplier result = supplierAdapter.findByName("Tech Solutions S.A.S");

        assertNotNull(result);
        assertEquals("Tech Solutions S.A.S", result.getName());
    }

    @Test
    void findByEmail_shouldReturnSupplier() {
        when(supplierRepository.findByEmail("contacto@techsolutions.com")).thenReturn(supplierEntity);
        when(supplierEntityMapper.supplierEntityToSupplier(supplierEntity)).thenReturn(supplier);

        Supplier result = supplierAdapter.findByEmail("contacto@techsolutions.com");

        assertNotNull(result);
        assertEquals("contacto@techsolutions.com", result.getEmail());
    }

    @Test
    void findByNit_shouldReturnSupplier() {
        when(supplierRepository.findByNit(123456789L)).thenReturn(supplierEntity);
        when(supplierEntityMapper.supplierEntityToSupplier(supplierEntity)).thenReturn(supplier);

        Supplier result = supplierAdapter.findByNit(123456789L);

        assertNotNull(result);
        assertEquals(123456789L, result.getNit());
    }

    @Test
    void saveSupplier_shouldReturnSavedSupplier() {
        when(supplierEntityMapper.supplierToSupplierEntity(supplier)).thenReturn(supplierEntity);
        when(supplierRepository.save(supplierEntity)).thenReturn(supplierEntity);
        when(supplierEntityMapper.supplierEntityToSupplier(supplierEntity)).thenReturn(supplier);

        Supplier result = supplierAdapter.saveSupplier(supplier);

        assertNotNull(result);
        assertEquals(supplier.getName(), result.getName());
    }
}
