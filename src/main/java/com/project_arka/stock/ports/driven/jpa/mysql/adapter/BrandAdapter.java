package com.project_arka.stock.ports.driven.jpa.mysql.adapter;

import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {
    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public Brand createBrand(Brand brand) {
        return brandEntityMapper.brandEntityToBrand(brandRepository.save(brandEntityMapper.brandToBrandEntity(brand)));
    }

    @Override
    public Brand findByName(String name) {
        return brandEntityMapper.brandEntityToBrand(brandRepository.findByName(name));
    }
}
