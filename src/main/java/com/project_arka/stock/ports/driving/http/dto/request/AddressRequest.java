package com.project_arka.stock.ports.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project_arka.stock.ports.driving.http.util.ApplicationConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddressRequest {
    @NotBlank(message = ADDRESS_STREET_EMPTY_EXCEPTION_MESSAGE)
    private String street;

    @NotBlank(message = ADDRESS_CITY_EMPTY_EXCEPTION_MESSAGE)
    private String city;

    @NotBlank(message = ADDRESS_STATE_EMPTY_EXCEPTION_MESSAGE)
    private String state;

    @NotBlank(message = ADDRESS_COUNTRY_EMPTY_EXCEPTION_MESSAGE)
    private String country;
    @NotBlank(message = ADDRESS_NOMENCLATURE_EMPTY_EXCEPTION_MESSAGE)
    private String nomenclature;
    @NotBlank(message = ADDRESS_OBSERVATION_EMPTY_EXCEPTION_MESSAGE)
    private String observation;
}
