package com.project_arka.stock.ports.driven.jpa.mysql.adapter;

import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {
    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public Brand saveBrand(Brand brand) {
        return brandEntityMapper.brandEntityToBrand(brandRepository.save(brandEntityMapper.brandToBrandEntity(brand)));
    }

    @Override
    public Brand findByName(String name) {
        return brandEntityMapper.brandEntityToBrand(brandRepository.findByName(name));
    }

    @Override
    public List<Brand> findAllBrands() {
        return brandRepository.findAll().stream().map(brandEntityMapper::brandEntityToBrand).toList();
    }

    @Override
    public Brand findBrandById(Long id) {
        return brandEntityMapper.brandEntityToBrand(brandRepository.findById(id).orElse(null));
    }
}
