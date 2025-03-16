package com.project_arka.stock.ports.driving.http.controller;

import com.project_arka.stock.data.SupplierData;
import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.domain.api.ISupplierServicePort;
import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.ports.driving.http.dto.request.CategoryRequest;
import com.project_arka.stock.ports.driving.http.dto.request.SupplierRequest;
import com.project_arka.stock.ports.driving.http.dto.response.CategoryResponse;
import com.project_arka.stock.ports.driving.http.dto.response.SupplierResponse;
import com.project_arka.stock.ports.driving.http.mapper.ICategoryMapperDto;
import com.project_arka.stock.ports.driving.http.mapper.ISupplierMapperDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplierControllerTest {

    @Mock
    private ISupplierServicePort supplierServicePort;

    @Mock
    private ISupplierMapperDto supplierMapperDto;

    @InjectMocks
    private SupplierController categoryController;

    private SupplierRequest supplierRequest;
    private SupplierResponse supplierResponse;

    @BeforeEach
    void setUp() {
        supplierRequest = SupplierData.getSupplierRequest();
        supplierResponse = SupplierData.getSupplierResponse();
    }

    @Test
    void createSupplier_ReturnsCreatedResponse() {

        var supplier = SupplierData.getSupplier();
        when(supplierMapperDto.supplierRequestToSupplier(any(SupplierRequest.class))).thenReturn(supplier);
        when(supplierServicePort.createSupplier(any(Supplier.class))).thenReturn(supplier);
        when(supplierMapperDto.supplierToSupplierResponse(any(Supplier.class))).thenReturn(supplierResponse);

        ResponseEntity<SupplierResponse> response = categoryController.createSupplier(supplierRequest);

        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(supplierResponse, response.getBody());
    }

}