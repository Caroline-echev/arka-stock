package com.project_arka.stock.ports.driven.jpa.mysql.mapper;

import com.project_arka.stock.data.CategoryData;
import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.CategoryEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ICategoryEntityMapperTest {

    private final ICategoryEntityMapper mapper = Mappers.getMapper(ICategoryEntityMapper.class);

    @Test
    void shouldMapCategoryEntityToCategory() {
        // Given
        CategoryEntity entity = CategoryData.getCategoryEntity();

        // When
        Category category = mapper.categoryEntityToCategory(entity);

        // Then
        assertNotNull(category);
        assertEquals(entity.getId(), category.getId());
        assertEquals(entity.getName(), category.getName());
        assertEquals(entity.getDescription(), category.getDescription());
    }

    @Test
    void shouldMapCategoryToCategoryEntity() {
        // Given
        Category category = CategoryData.getCategory();

        // When
        CategoryEntity entity = mapper.categoryToCategoryEntity(category);

        // Then
        assertNotNull(entity);
        assertEquals(category.getId(), entity.getId());
        assertEquals(category.getName(), entity.getName());
        assertEquals(category.getDescription(), entity.getDescription());
    }
}