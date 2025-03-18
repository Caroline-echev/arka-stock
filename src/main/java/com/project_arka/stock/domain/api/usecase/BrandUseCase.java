package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.domain.api.IBrandServicePort;
import com.project_arka.stock.domain.exception.conflict.BrandAllreadyExistsException;
import com.project_arka.stock.domain.exception.notfound.BrandNotFoundException;
import com.project_arka.stock.domain.exception.notfound.EmptyBrandListException;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static com.project_arka.stock.domain.util.DomainConstants.*;

@RequiredArgsConstructor
public class BrandUseCase implements IBrandServicePort {

    private  final IBrandPersistencePort brandPersistencePort;
    @Override
    public Brand createBrand(Brand brand) {
        if(brandPersistencePort.findByName(brand.getName()) != null)
            throw new BrandAllreadyExistsException(BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE);

        return brandPersistencePort.saveBrand(brand);
    }

    @Override
    public List<Brand> findAllBrands(Boolean asc) {
        List<Brand> brands = brandPersistencePort.findAllBrands();
        if (brands == null || brands.isEmpty()) {
            throw new EmptyBrandListException(BRAND_LIST_EMPTY_EXCEPTION_MESSAGE);
        }
        return sortBrands(brands, asc);
    }

    @Override
    public Brand findBrandById(Long id) {
        Brand brand = brandPersistencePort.findBrandById(id);
        if(brand == null){
            throw new BrandNotFoundException(BRAND_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        return brand;
    }

    @Override
    public Brand updateBrand(Brand brand, Long id) {
        if(brandPersistencePort.findBrandById(id) == null){
            throw new BrandNotFoundException(BRAND_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        brand.setId(id);
        return brandPersistencePort.saveBrand(brand);

    }

    private List<Brand> sortBrands(List<Brand> brands, Boolean asc) {
        return brands.stream()
                .sorted(asc ? Comparator.comparing(Brand::getName)
                        : Comparator.comparing(Brand::getName).reversed())
                .toList();
    }

}
