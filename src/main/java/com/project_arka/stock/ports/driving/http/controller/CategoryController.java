package com.project_arka.stock.ports.driving.http.controller;

import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.ports.driving.http.dto.request.CategoryRequest;
import com.project_arka.stock.ports.driving.http.dto.response.BrandResponse;
import com.project_arka.stock.ports.driving.http.dto.response.CategoryResponse;
import com.project_arka.stock.ports.driving.http.mapper.ICategoryMapperDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategories(@RequestParam(defaultValue = "true") boolean asc) {
        List<CategoryResponse> categoryResponses = categoryServicePort.findAllCategories(asc)
                .stream()
                .map(categoryMapperDto::categoryToCategoryResponse)
                .toList();
        return ResponseEntity.ok(categoryResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryMapperDto.categoryToCategoryResponse(categoryServicePort.findCategoryById(id)));
    }
}