package com.project_arka.stock.ports.driving.http.controller;

import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.ports.driving.http.dto.request.CategoryRequest;
import com.project_arka.stock.ports.driving.http.dto.response.CategoryResponse;
import com.project_arka.stock.ports.driving.http.mapper.ICategoryMapperDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final ICategoryServicePort categoryServicePort;
    private final ICategoryMapperDto categoryMapperDto;

    @PostMapping("/")
    public ResponseEntity<CategoryResponse> createBrand(@RequestBody @Valid CategoryRequest   categoryRequest) {
        return ResponseEntity.ok(categoryMapperDto.categoryToCategoryResponse(categoryServicePort.createCategory(categoryMapperDto.categoryRequestToCategory(categoryRequest))));
    }
}