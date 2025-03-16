package com.project_arka.stock.ports.driving.http.mapper;

import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.ports.driving.http.dto.request.SupplierRequest;
import com.project_arka.stock.ports.driving.http.dto.response.SupplierResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.project_arka.stock.ports.driving.http.util.ApplicationConstants.SPRING_MAPPING;

@Mapper(componentModel = SPRING_MAPPING, uses = IAddressMapperDto.class)
public interface ISupplierMapperDto {
    SupplierResponse supplierToSupplierResponse(Supplier supplier);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", source = "address", qualifiedByName = "addressToString")
    Supplier supplierRequestToSupplier(SupplierRequest supplierRequest);


}
