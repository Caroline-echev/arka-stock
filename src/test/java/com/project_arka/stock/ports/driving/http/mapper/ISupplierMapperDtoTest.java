package com.project_arka.stock.ports.driving.http.mapper;

import com.project_arka.stock.data.SupplierData;
import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.ports.driving.http.dto.response.SupplierResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ISupplierMapperDtoTest {

    private final ISupplierMapperDto mapper = Mappers.getMapper(ISupplierMapperDto.class);

    @Test
    void supplierToSupplierResponse_shouldMapCorrectly() {

        Supplier supplier = SupplierData.getSupplier();

        SupplierResponse response = mapper.supplierToSupplierResponse(supplier);

        assertNotNull(response);
        assertEquals(supplier.getName(), response.getName());
        assertEquals(supplier.getEmail(), response.getEmail());
        assertEquals(supplier.getNit(), response.getNit());
        assertEquals(supplier.getPhone(), response.getPhone());
        assertEquals(supplier.getContactName(), response.getContactName());
        assertEquals(supplier.getWebsite(), response.getWebsite());
        assertNotNull(response.getAddress());
    }




}
