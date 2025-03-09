package com.project_arka.stock.ports.driving.http.controller;
import com.project_arka.stock.domain.api.IBrandServicePort;
import com.project_arka.stock.ports.driving.http.dto.request.BrandRequest;
import com.project_arka.stock.ports.driving.http.dto.response.BrandResponse;
import com.project_arka.stock.ports.driving.http.mapper.IBrandMapperDto;
import com.project_arka.stock.data.BrandData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrandControllerTest {

    @Mock
    private IBrandServicePort brandServicePort;

    @Mock
    private IBrandMapperDto brandMapperDto;

    @InjectMocks
    private BrandController brandController;

    private BrandRequest brandRequest;
    private BrandResponse brandResponse;

    @BeforeEach
    void setUp() {
        brandRequest = BrandData.getBrandRequest();
        brandResponse = BrandData.getBrandResponse();
    }

    @Test
    void createBrand_Success() {
        when(brandMapperDto.brandToBrandRequest(brandRequest)).thenReturn(BrandData.getBrand());
        when(brandServicePort.createBrand(any())).thenReturn(BrandData.getBrand());
        when(brandMapperDto.brandToBrandResponse(any())).thenReturn(brandResponse);

        ResponseEntity<BrandResponse> response = brandController.createBrand(brandRequest);

        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(brandResponse, response.getBody());
    }

    @Test
    void findAllBrands_Success() {
        when(brandServicePort.findAllBrands(true)).thenReturn(BrandData.getBrandList());
        when(brandMapperDto.brandToBrandResponse(any())).thenReturn(brandResponse);

        ResponseEntity<List<BrandResponse>> response = brandController.findAllBrands(true);

        assertNotNull(response);
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void findBrandById_Success() {
        when(brandServicePort.findBrandById(1L)).thenReturn(BrandData.getBrand());
        when(brandMapperDto.brandToBrandResponse(any())).thenReturn(brandResponse);

        ResponseEntity<BrandResponse> response = brandController.findBrandById(1L);

        assertNotNull(response);
        assertEquals(brandResponse, response.getBody());
    }

    @Test
    void updateBrand_Success() {
        when(brandMapperDto.brandToBrandRequest(brandRequest)).thenReturn(BrandData.getBrand());
        when(brandServicePort.updateBrand(any(), eq(1L))).thenReturn(BrandData.getBrand());
        when(brandMapperDto.brandToBrandResponse(any())).thenReturn(brandResponse);

        ResponseEntity<BrandResponse> response = brandController.updateBrand(brandRequest, 1L);

        assertNotNull(response);
        assertEquals(brandResponse, response.getBody());
    }
}
