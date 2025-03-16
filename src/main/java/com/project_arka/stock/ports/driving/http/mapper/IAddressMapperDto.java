package com.project_arka.stock.ports.driving.http.mapper;

import com.project_arka.stock.domain.model.Address;
import com.project_arka.stock.ports.driving.http.dto.request.AddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static com.project_arka.stock.ports.driving.http.util.ApplicationConstants.SPRING_MAPPING;

@Mapper(componentModel = SPRING_MAPPING)
public interface IAddressMapperDto {


    @Named("addressToString")
    default String addressToString(AddressRequest request) {
        return String.format("País: %s, Estado: %s, Ciudad: %s, Calle: %s, Nomenclatura: %s, Observación: %s",
                request.getCountry(),
                request.getState(),
                request.getCity(),
                request.getStreet(),
                request.getNomenclature(),
                request.getObservation());
    }

}
