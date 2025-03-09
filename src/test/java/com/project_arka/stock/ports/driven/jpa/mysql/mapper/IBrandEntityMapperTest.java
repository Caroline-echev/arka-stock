package com.project_arka.stock.ports.driven.jpa.mysql.mapper;

import com.project_arka.stock.data.BrandData;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.BrandEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class IBrandEntityMapperTest {

     private final IBrandEntityMapper brandMapper = Mappers.getMapper(IBrandEntityMapper.class);


    @Test
    void shouldMapBrandEntityToBrand() {

        BrandEntity entity = BrandData.getBrandEntity();

        Brand brand = brandMapper.brandEntityToBrand(entity);

        assertNotNull(brand);
        assertEquals(entity.getId(), brand.getId());
        assertEquals(entity.getName(), brand.getName());
    }

    @Test
    void shouldMapBrandToBrandEntity() {

        Brand brand = BrandData.getBrand();

        BrandEntity entity = brandMapper.brandToBrandEntity(brand);

        assertNotNull(entity);
        assertEquals(brand.getId(), entity.getId());
        assertEquals(brand.getName(), entity.getName());
    }
}