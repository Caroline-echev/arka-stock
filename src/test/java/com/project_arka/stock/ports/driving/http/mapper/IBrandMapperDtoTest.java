package com.project_arka.stock.ports.driving.http.mapper;

import com.project_arka.stock.data.BrandData;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.ports.driving.http.dto.request.BrandRequest;
import com.project_arka.stock.ports.driving.http.dto.response.BrandResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class IBrandMapperDtoTest {
    private final IBrandMapperDto brandMapperDto = Mappers.getMapper(IBrandMapperDto.class);


    @Test
    void shouldMapBrandToBrandResponse() {
        Brand brand = BrandData.getBrand();

        BrandResponse response = brandMapperDto.brandToBrandResponse(brand);

        assertNotNull(response);
        assertEquals(brand.getId(), response.getId());
        assertEquals(brand.getName(), response.getName());
    }

    @Test
    void shouldMapBrandRequestToBrand() {
        BrandRequest request = BrandData.getBrandRequest();

        Brand brand = brandMapperDto.brandToBrandRequest(request);

        assertNotNull(brand);
        assertEquals(request.getName(), brand.getName());
    }

}