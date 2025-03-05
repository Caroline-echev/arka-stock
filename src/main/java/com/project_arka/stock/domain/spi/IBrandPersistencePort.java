package com.project_arka.stock.domain.spi;

import com.project_arka.stock.domain.model.Brand;

public interface IBrandPersistencePort {
    Brand createBrand(Brand brand);
    Brand findByName(String name);
}
