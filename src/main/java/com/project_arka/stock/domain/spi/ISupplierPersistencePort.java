package com.project_arka.stock.domain.spi;

import com.project_arka.stock.domain.model.Supplier;

public interface ISupplierPersistencePort {

    Supplier findByName(String name);
    Supplier findByEmail(String email);
    Supplier findByNit(Long nit);
    Supplier saveSupplier(Supplier supplier);
}
