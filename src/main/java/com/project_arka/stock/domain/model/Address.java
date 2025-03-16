package com.project_arka.stock.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private String nomenclature;
    private String observation;
}
