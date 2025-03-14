package com.project_arka.stock.domain.api;

import com.project_arka.stock.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {
    Brand createBrand(Brand brand);
    List<Brand> findAllBrands(Boolean asc);
    Brand findBrandById(Long id);
    Brand updateBrand(Brand brand, Long id);
}
