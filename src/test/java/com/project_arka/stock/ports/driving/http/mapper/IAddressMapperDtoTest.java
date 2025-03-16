package com.project_arka.stock.ports.driving.http.mapper;


import com.project_arka.stock.ports.driving.http.dto.request.AddressRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IAddressMapperDtoTest {

    private final IAddressMapperDto addressMapper = new IAddressMapperDto() {};

    @Test
    void addressToString_shouldReturnFormattedString() {
        AddressRequest request = AddressRequest.builder()
                .country("Colombia")
                .state("Antioquia")
                .city("Medellín")
                .street("Av. El Poblado")
                .nomenclature("Cra 43A # 1-50")
                .observation("Cerca al parque")
                .build();

        String expected = "País: Colombia, Estado: Antioquia, Ciudad: Medellín, Calle: Av. El Poblado, Nomenclatura: Cra 43A # 1-50, Observación: Cerca al parque";

        String result = addressMapper.addressToString(request);

        assertEquals(expected, result);
    }
}
