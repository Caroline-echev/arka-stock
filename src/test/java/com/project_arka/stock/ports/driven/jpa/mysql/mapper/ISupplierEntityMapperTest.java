package com.project_arka.stock.ports.driven.jpa.mysql.mapper;

import com.project_arka.stock.data.SupplierData;
import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.SupplierEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ISupplierEntityMapperTest {

    private final ISupplierEntityMapper mapper = Mappers.getMapper(ISupplierEntityMapper.class);

    @Test
    void supplierEntityToSupplier_shouldMapCorrectly() {
        SupplierEntity supplierEntity = SupplierData.getSupplierEntity();

        Supplier supplier = mapper.supplierEntityToSupplier(supplierEntity);

        assertNotNull(supplier);
        assertEquals(supplierEntity.getId(), supplier.getId());
        assertEquals(supplierEntity.getName(), supplier.getName());
        assertEquals(supplierEntity.getEmail(), supplier.getEmail());
        assertEquals(supplierEntity.getNit(), supplier.getNit());
    }

    @Test
    void supplierToSupplierEntity_shouldMapCorrectly() {
        Supplier supplier = SupplierData.getSupplier();

        SupplierEntity supplierEntity = mapper.supplierToSupplierEntity(supplier);

        assertNotNull(supplierEntity);
        assertEquals(supplier.getId(), supplierEntity.getId());
        assertEquals(supplier.getName(), supplierEntity.getName());
        assertEquals(supplier.getEmail(), supplierEntity.getEmail());
        assertEquals(supplier.getNit(), supplierEntity.getNit());
    }
}
