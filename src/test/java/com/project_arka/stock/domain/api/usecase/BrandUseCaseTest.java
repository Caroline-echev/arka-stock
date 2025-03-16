package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.data.BrandData;
import com.project_arka.stock.domain.exception.conflict.BrandAllreadyExistsException;
import com.project_arka.stock.domain.exception.notfound.BrandNotFoundException;
import com.project_arka.stock.domain.exception.notfound.EmptyBrandListException;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BrandUseCaseTest {

    @Mock
    private IBrandPersistencePort brandPersistencePort;

    @InjectMocks
    private BrandUseCase brandUseCase;

    private Brand testBrand;

    @BeforeEach
    void setUp() {
        testBrand = BrandData.getBrand();
    }

    @Test
    void createBrand_Success() {
        when(brandPersistencePort.findByName(testBrand.getName())).thenReturn(null);
        when(brandPersistencePort.saveBrand(testBrand)).thenReturn(testBrand);

        Brand result = brandUseCase.createBrand(testBrand);

        assertNotNull(result);
        assertEquals(testBrand.getName(), result.getName());
        verify(brandPersistencePort).saveBrand(testBrand);
    }

    @Test
    void createBrand_AlreadyExists() {
        when(brandPersistencePort.findByName(testBrand.getName())).thenReturn(testBrand);
        assertThrows(BrandAllreadyExistsException.class, () -> brandUseCase.createBrand(testBrand));
    }

    @Test
    void findAllBrands_Success() {
        List<Brand> brands = BrandData.getBrandList();
        when(brandPersistencePort.findAllBrands()).thenReturn(brands);

        List<Brand> result = brandUseCase.findAllBrands(true);

        assertFalse(result.isEmpty());
        assertEquals(brands.size(), result.size());
    }

    @Test
    void findAllBrands_Success_Desc() {
        List<Brand> brands = BrandData.getBrandList();
        when(brandPersistencePort.findAllBrands()).thenReturn(brands);

        List<Brand> result = brandUseCase.findAllBrands(false);

        assertFalse(result.isEmpty());
        assertEquals(brands.size(), result.size());
    }

    @Test
    void findAllBrands_EmptyList() {
        when(brandPersistencePort.findAllBrands()).thenReturn(List.of());
        assertThrows(EmptyBrandListException.class, () -> brandUseCase.findAllBrands(true));
    }

    @Test
    void findBrandById_Success() {
        when(brandPersistencePort.findBrandById(1L)).thenReturn(testBrand);
        Brand result = brandUseCase.findBrandById(1L);
        assertNotNull(result);
        assertEquals(testBrand.getId(), result.getId());
    }

    @Test
    void findBrandById_NotFound() {
        when(brandPersistencePort.findBrandById(1L)).thenReturn(null);
        assertThrows(BrandNotFoundException.class, () -> brandUseCase.findBrandById(1L));
    }

    @Test
    void updateBrand_Success() {
        when(brandPersistencePort.findBrandById(1L)).thenReturn(testBrand);
        when(brandPersistencePort.saveBrand(any())).thenReturn(testBrand);

        Brand result = brandUseCase.updateBrand(testBrand, 1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void updateBrand_NotFound() {
        when(brandPersistencePort.findBrandById(1L)).thenReturn(null);
        assertThrows(BrandNotFoundException.class, () -> brandUseCase.updateBrand(testBrand, 1L));
    }
}
