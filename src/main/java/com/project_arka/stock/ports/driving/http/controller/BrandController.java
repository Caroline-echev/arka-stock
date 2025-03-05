package com.project_arka.stock.ports.driving.http.controller;

import com.project_arka.stock.domain.api.IBrandServicePort;
import com.project_arka.stock.ports.driving.http.dto.request.BrandRequest;
import com.project_arka.stock.ports.driving.http.dto.response.BrandResponse;
import com.project_arka.stock.ports.driving.http.mapper.IBrandMapperDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandController {
    private final IBrandServicePort brandServicePort;
    private final IBrandMapperDto brandMapperDto;

    @PostMapping("/")
    public ResponseEntity<BrandResponse> createBrand(@RequestBody  @Valid BrandRequest brandRequest) {
        return ResponseEntity.ok(brandMapperDto.brandToBrandResponse(brandServicePort.createBrand(brandMapperDto.brandToBrandRequest(brandRequest))));
    }
}
