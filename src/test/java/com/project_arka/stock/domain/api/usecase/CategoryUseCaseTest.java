package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.data.CategoryData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.project_arka.stock.domain.exception.*;
import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    private Category testCategory;

    @BeforeEach
    void setUp() {
        testCategory = CategoryData.getCategory();
    }

    @Test
    void createCategory_Success() {
        when(categoryPersistencePort.findByName(testCategory.getName())).thenReturn(null);
        when(categoryPersistencePort.saveCategory(testCategory)).thenReturn(testCategory);

        Category result = categoryUseCase.createCategory(testCategory);

        assertNotNull(result);
        assertEquals(testCategory.getName(), result.getName());
        verify(categoryPersistencePort).saveCategory(testCategory);
    }

    @Test
    void createCategory_AlreadyExists() {
        when(categoryPersistencePort.findByName(testCategory.getName())).thenReturn(testCategory);
        assertThrows(CategoryAllreadyExistsException.class, () -> categoryUseCase.createCategory(testCategory));
    }

    @Test
    void findAllCategories_Success() {
        List<Category> categories = CategoryData.getCategoryList();
        when(categoryPersistencePort.findAllCategories()).thenReturn(categories);

        List<Category> result = categoryUseCase.findAllCategories(true);

        assertFalse(result.isEmpty());
        assertEquals(categories.size(), result.size());
    }

    @Test
    void findAllCategories_Success_Desc() {
        List<Category> categories = CategoryData.getCategoryList();
        when(categoryPersistencePort.findAllCategories()).thenReturn(categories);

        List<Category> result = categoryUseCase.findAllCategories(false);

        assertFalse(result.isEmpty());
        assertEquals(categories.size(), result.size());
    }
    @Test
    void findAllCategories_EmptyList() {
        when(categoryPersistencePort.findAllCategories()).thenReturn(List.of());
        assertThrows(EmptyCategoryListException.class, () -> categoryUseCase.findAllCategories(true));
    }

    @Test
    void findCategoryById_Success() {
        when(categoryPersistencePort.findCategoryById(1L)).thenReturn(testCategory);
        Category result = categoryUseCase.findCategoryById(1L);
        assertNotNull(result);
        assertEquals(testCategory.getId(), result.getId());
    }

    @Test
    void findCategoryById_NotFound() {
        when(categoryPersistencePort.findCategoryById(1L)).thenReturn(null);
        assertThrows(CategoryNotFoundException.class, () -> categoryUseCase.findCategoryById(1L));
    }

    @Test
    void updateCategory_Success() {
        when(categoryPersistencePort.findCategoryById(1L)).thenReturn(testCategory);
        when(categoryPersistencePort.saveCategory(any())).thenReturn(testCategory);

        Category result = categoryUseCase.updateCategory(testCategory, 1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void updateCategory_NotFound() {
        when(categoryPersistencePort.findCategoryById(1L)).thenReturn(null);
        assertThrows(CategoryNotFoundException.class, () -> categoryUseCase.updateCategory(testCategory, 1L));
    }
}
