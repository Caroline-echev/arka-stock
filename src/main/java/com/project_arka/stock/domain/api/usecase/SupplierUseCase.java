package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.domain.api.ISupplierServicePort;
import com.project_arka.stock.domain.exception.conflict.SupplierAllreadyExistsException;
import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.domain.spi.ISupplierPersistencePort;
import lombok.RequiredArgsConstructor;

import static com.project_arka.stock.domain.util.DomainConstants.SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE;

@RequiredArgsConstructor
public class SupplierUseCase implements ISupplierServicePort {

    private  final ISupplierPersistencePort supplierPersistencePort;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        if(supplierPersistencePort.findByName(supplier.getName()) != null)
            throw new SupplierAllreadyExistsException(SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE);
        if(supplierPersistencePort.findByEmail(supplier.getEmail()) != null)
            throw new SupplierAllreadyExistsException(SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE);
        if(supplierPersistencePort.findByNit(supplier.getNit()) != null)
            throw new SupplierAllreadyExistsException(SUPPLIER_ALREADY_EXISTS_EXCEPTION_MESSAGE);
        return supplierPersistencePort.saveSupplier(supplier);
    }

}
