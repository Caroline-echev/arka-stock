package com.project_arka.stock.ports.driven.jpa.mysql.adapter;

import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.domain.spi.ISupplierPersistencePort;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.ISupplierEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.ISupplierRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplierAdapter implements ISupplierPersistencePort {
    private final ISupplierRepository supplierRepository;
    private final ISupplierEntityMapper supplierEntityMapper;
    @Override
    public Supplier findByName(String name) {
        return supplierEntityMapper.supplierEntityToSupplier(supplierRepository.findByName(name));
    }

    @Override
    public Supplier findByEmail(String email) {
        return supplierEntityMapper.supplierEntityToSupplier(supplierRepository.findByEmail(email));
    }

    @Override
    public Supplier findByNit(Long nit) {
        return supplierEntityMapper.supplierEntityToSupplier(supplierRepository.findByNit(nit));
    }

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierEntityMapper.supplierEntityToSupplier(supplierRepository.save(supplierEntityMapper.supplierToSupplierEntity(supplier)));
    }
}
