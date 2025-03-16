package com.project_arka.stock.ports.driving.http.controller;

import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.domain.api.ISupplierServicePort;
import com.project_arka.stock.ports.driving.http.dto.request.SupplierRequest;
import com.project_arka.stock.ports.driving.http.dto.response.SupplierResponse;
import com.project_arka.stock.ports.driving.http.mapper.ICategoryMapperDto;
import com.project_arka.stock.ports.driving.http.mapper.ISupplierMapperDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/supplier")
public class SupplierController {
    private final ISupplierServicePort supplierServicePort;
    private final ISupplierMapperDto supplierMapperDto;

    @PostMapping("/")
    public ResponseEntity<SupplierResponse> createSupplier(@RequestBody @Valid  SupplierRequest supplierRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                supplierMapperDto.supplierToSupplierResponse(
                        supplierServicePort.createSupplier(
                                supplierMapperDto.supplierRequestToSupplier(supplierRequest))));
    }
}
