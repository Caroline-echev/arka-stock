package com.project_arka.stock.ports.driving.http.mapper;

import com.project_arka.stock.data.CategoryData;
import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.ports.driving.http.dto.request.CategoryRequest;
import com.project_arka.stock.ports.driving.http.dto.response.CategoryResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ICategoryMapperDtoTest {
    private final ICategoryMapperDto categoryMapperDto = Mappers.getMapper(ICategoryMapperDto.class);


    @Test
    void shouldMapCategoryToCategoryResponse() {
        Category category = CategoryData.getCategory();

        CategoryResponse response = categoryMapperDto.categoryToCategoryResponse(category);

        assertNotNull(response);
        assertEquals(category.getId(), response.getId());
        assertEquals(category.getName(), response.getName());
        assertEquals(category.getDescription(), response.getDescription());
    }

    @Test
    void shouldMapCategoryRequestToCategory() {
        CategoryRequest request = CategoryData.getCategoryRequest();

        Category category = categoryMapperDto.categoryRequestToCategory(request);

        assertNotNull(category);
        assertEquals(request.getName(), category.getName());
        assertEquals(request.getDescription(), category.getDescription());
    }

}