package com.project_arka.stock.data;

import com.project_arka.stock.domain.model.Supplier;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.SupplierEntity;
import com.project_arka.stock.ports.driving.http.dto.request.SupplierRequest;
import com.project_arka.stock.ports.driving.http.dto.response.SupplierResponse;

public class SupplierData {

    public static SupplierRequest getSupplierRequest() {
        return SupplierRequest.builder()
                .nit(123456789L)
                .name("Tech Solutions S.A.S")
                .contactName("Carlos Martínez")
                .description("Proveedor de equipos tecnológicos y soluciones IT.")
                .email("contacto@techsolutions.com")
                .phone("+573001234567")
                .website("https://www.techsolutions.com")
                .address(AddressData.getAddressRequest())
                .build();
    }

    public static SupplierResponse getSupplierResponse() {
        return SupplierResponse.builder()
                .nit(123456789L)
                .name("Tech Solutions S.A.S")
                .contactName("Carlos Martínez")
                .description("Proveedor de información tecnológicos y soluciones IT.")
                .email("contacto@techsolutions.com")
                .phone("+573001234567")
                .website("https://www.techsolutions.com")
                .address(AddressData.getAddress())
                .build();
    }

    public static Supplier getSupplier() {
        return Supplier.builder()
                .id(1L)
                .nit(123456789L)
                .name("Tech Solutions S.A.S")
                .contactName("Carlos Martínez")
                .description("Proveedor de equipos tecnológicos y soluciones IT.")
                .email("contacto@techsolutions.com")
                .phone("+573001234567")
                .website("https://www.techsolutions.com")
                .address(AddressData.getAddress())
                .build();
    }

    public static SupplierEntity getSupplierEntity() {
        return SupplierEntity.builder()
                .id(1L)
                .nit(123456789L)
                .name("Tech Solutions S.A.S")
                .contactName("Carlos Martínez")
                .description("Proveedor de información tecnológicos y soluciones IT.")
                .email("contacto@techsolutions.com")
                .phone("+573001234567")
                .website("https://www.techsolutions.com")
                .address(AddressData.getAddress())
                .build();
    }
}
