package com.project_arka.stock.ports.driven.jpa.mysql.adapter;

import com.project_arka.stock.data.CategoryData;
import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.CategoryEntity;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private ICategoryEntityMapper categoryEntityMapper;

   @InjectMocks
    private CategoryAdapter categoryAdapter;

    private Category testCategory;
    private CategoryEntity testCategoryEntity;

    @BeforeEach
    void setUp() {
        testCategory = CategoryData.getCategory();
        testCategoryEntity = CategoryData.getCategoryEntity();
    }

    @Test
    void saveCategory_Success() {
        when(categoryEntityMapper.categoryToCategoryEntity(testCategory)).thenReturn(testCategoryEntity);
        when(categoryRepository.save(testCategoryEntity)).thenReturn(testCategoryEntity);
        when(categoryEntityMapper.categoryEntityToCategory(testCategoryEntity)).thenReturn(testCategory);

        Category result = categoryAdapter.saveCategory(testCategory);

        assertNotNull(result);
        assertEquals(testCategory.getName(), result.getName());
        assertEquals(testCategory.getDescription(), result.getDescription());

    }

    @Test
    void findCategoryById_Success() {
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(testCategoryEntity));
        when(categoryEntityMapper.categoryEntityToCategory(testCategoryEntity)).thenReturn(testCategory);

        Category result = categoryAdapter.findCategoryById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void findByName_Success() {
        when(categoryRepository.findByName(testCategory.getName())).thenReturn(testCategoryEntity);
        when(categoryEntityMapper.categoryEntityToCategory(testCategoryEntity)).thenReturn(testCategory);

        Category result = categoryAdapter.findByName(testCategory.getName());

        assertNotNull(result);
        assertEquals(testCategory.getName(), result.getName());
    }

    @Test
    void findAllCategories_Success() {
        when(categoryRepository.findAll()).thenReturn(List.of(testCategoryEntity));
        when(categoryEntityMapper.categoryEntityToCategory(testCategoryEntity)).thenReturn(testCategory);

        List<Category> result = categoryAdapter.findAllCategories();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }


}