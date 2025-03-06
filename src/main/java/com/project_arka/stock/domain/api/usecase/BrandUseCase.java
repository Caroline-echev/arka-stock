package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.domain.api.IBrandServicePort;
import com.project_arka.stock.domain.exception.BrandAllreadyExistsException;
import com.project_arka.stock.domain.exception.EmptyBrandListException;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static com.project_arka.stock.domain.util.DomainConstants.BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE;
import static com.project_arka.stock.domain.util.DomainConstants.BRAND_LIST_EMPTY_EXCEPTION_MESSAGE;

@RequiredArgsConstructor
public class BrandUseCase implements IBrandServicePort {
    private  final IBrandPersistencePort brandPersistencePort;
    @Override
    public Brand createBrand(Brand brand) {
        if(brandPersistencePort.findByName(brand.getName()) != null)
            throw new BrandAllreadyExistsException(BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE);

        return brandPersistencePort.createBrand(brand);
    }

    @Override
    public List<Brand> findAllBrands(Boolean asc) {
        List<Brand> brands = brandPersistencePort.findAllBrands();

        if (brands == null || brands.isEmpty()) {
            throw new EmptyBrandListException(BRAND_LIST_EMPTY_EXCEPTION_MESSAGE);
        }

        return sortBrands(brands, asc);
    }

    private List<Brand> sortBrands(List<Brand> brands, Boolean asc) {
        return brands.stream()
                .sorted(asc ? Comparator.comparing(Brand::getName)
                        : Comparator.comparing(Brand::getName).reversed())
                .toList();
    }

}
