package com.project_arka.stock.domain.spi;

import com.project_arka.stock.domain.model.Brand;

import java.util.List;

public interface IBrandPersistencePort {
    Brand saveBrand(Brand brand);
    Brand findByName(String name);
    List<Brand> findAllBrands();
    Brand findBrandById(Long id);
}
