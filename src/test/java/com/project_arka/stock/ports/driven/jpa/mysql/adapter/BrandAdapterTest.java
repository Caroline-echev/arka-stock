package com.project_arka.stock.ports.driven.jpa.mysql.adapter;

import com.project_arka.stock.data.BrandData;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.BrandEntity;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.IBrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandAdapterTest {

    @Mock
    private IBrandRepository brandRepository;

    @Mock
    private IBrandEntityMapper brandEntityMapper;

    @InjectMocks
    private BrandAdapter brandAdapter;

    private Brand testBrand;
    private BrandEntity testBrandEntity;

    @BeforeEach
    void setUp() {
        testBrand = BrandData.getBrand();
        testBrandEntity = BrandData.getBrandEntity();
    }
    @Test
    void createBrand_Success() {
        when(brandEntityMapper.brandToBrandEntity(testBrand)).thenReturn(testBrandEntity);
        when(brandRepository.save(testBrandEntity)).thenReturn(testBrandEntity);
        when(brandEntityMapper.brandEntityToBrand(testBrandEntity)).thenReturn(testBrand);

        Brand brand = brandAdapter.saveBrand(testBrand);

        assertNotNull(brand);
        assertEquals(testBrand.getName(), brand.getName());
        assertEquals(testBrand.getDescription(), brand.getDescription());

    }
    @Test
    void findByName_Success() {
        when(brandRepository.findByName("Logitech")).thenReturn(testBrandEntity);
        when(brandEntityMapper.brandEntityToBrand(testBrandEntity)).thenReturn(testBrand);

        Brand result = brandAdapter.findByName("Logitech");

        assertNotNull(result);
        assertEquals("Logitech", result.getName());
    }

    @Test
    void findAllBrands_Success() {
        List<BrandEntity> brandEntities = List.of(testBrandEntity);
        when(brandRepository.findAll()).thenReturn(brandEntities);
        when(brandEntityMapper.brandEntityToBrand(testBrandEntity)).thenReturn(testBrand);

        List<Brand> result = brandAdapter.findAllBrands();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }

    @Test
    void findBrandById_Success() {
        when(brandRepository.findById(1L)).thenReturn(Optional.of(testBrandEntity));
        when(brandEntityMapper.brandEntityToBrand(testBrandEntity)).thenReturn(testBrand);

        Brand result = brandAdapter.findBrandById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
}



