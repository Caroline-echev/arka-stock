package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.domain.api.IBrandServicePort;
import com.project_arka.stock.domain.exception.BrandAllreadyExistsException;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;

import static com.project_arka.stock.domain.util.DomainConstants.BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE;

@RequiredArgsConstructor
public class BrandUseCase implements IBrandServicePort {
    private  final IBrandPersistencePort brandPersistencePort;
    @Override
    public Brand createBrand(Brand brand) {
        if(brandPersistencePort.findByName(brand.getName()) != null)
            throw new BrandAllreadyExistsException(BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE);

        return brandPersistencePort.createBrand(brand);
    }

}
