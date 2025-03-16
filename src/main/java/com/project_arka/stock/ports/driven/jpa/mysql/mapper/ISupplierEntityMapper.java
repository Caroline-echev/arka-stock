package com.project_arka.stock.ports.driven.jpa.mysql.mapper;

import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.SupplierEntity;
import org.mapstruct.Mapper;

import static com.project_arka.stock.ports.driven.jpa.mysql.util.AdapterConstants.SPRING_MAPPER;

@Mapper(componentModel = SPRING_MAPPER)
public interface ISupplierEntityMapper {
    Supplier supplierEntityToSupplier(SupplierEntity supplierEntity);

    SupplierEntity supplierToSupplierEntity(Supplier supplier);
}
