package com.project_arka.stock.ports.driving.http.controller;

import com.project_arka.stock.data.CategoryData;
import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.ports.driving.http.dto.request.CategoryRequest;
import com.project_arka.stock.ports.driving.http.dto.response.CategoryResponse;
import com.project_arka.stock.ports.driving.http.mapper.ICategoryMapperDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

   @Mock
   private ICategoryServicePort categoryServicePort;

   @Mock
   private ICategoryMapperDto categoryMapperDto;

   @InjectMocks
   private CategoryController categoryController;

   private CategoryRequest categoryRequest;
   private CategoryResponse categoryResponse;

   @BeforeEach
   void setUp() {
      categoryRequest = CategoryData.getCategoryRequest();
      categoryResponse = CategoryData.getCategoryResponse();
   }

   @Test
   void createCategory_Success() {
      when(categoryMapperDto.categoryRequestToCategory(categoryRequest)).thenReturn(CategoryData.getCategory());
      when(categoryServicePort.createCategory(any())).thenReturn(CategoryData.getCategory());
      when(categoryMapperDto.categoryToCategoryResponse(any())).thenReturn(categoryResponse);

      ResponseEntity<CategoryResponse> response = categoryController.createBrand(categoryRequest);

      assertNotNull(response);
      assertEquals(response.getStatusCodeValue(), 201);
      assertEquals(response.getBody(), categoryResponse);
   }

   @Test
   void findAllCategories_Success() {

      when(categoryServicePort.findAllCategories(true)).thenReturn(CategoryData.getCategoryList());
      when(categoryMapperDto.categoryToCategoryResponse(any())).thenReturn(categoryResponse);

      ResponseEntity<List<CategoryResponse>> response = categoryController.findAllCategories(true);

      assertNotNull(response);
      assertFalse(response.getBody().isEmpty());
   }

   @Test
   void findCategoryById_Success() {
      when(categoryServicePort.findCategoryById(1L)).thenReturn(CategoryData.getCategory());
      when(categoryMapperDto.categoryToCategoryResponse(any())).thenReturn(categoryResponse);

      ResponseEntity<CategoryResponse> response = categoryController.findCategoryById(1L);

      assertNotNull(response);
      assertEquals(response.getBody(), categoryResponse);
   }

   @Test
   void updateCategory_Success() {
      when(categoryMapperDto.categoryRequestToCategory(categoryRequest)).thenReturn(CategoryData.getCategory());
      when(categoryServicePort.updateCategory(any(), eq(1L))).thenReturn(CategoryData.getCategory());
      when(categoryMapperDto.categoryToCategoryResponse(any())).thenReturn(categoryResponse);

      ResponseEntity<CategoryResponse> response = categoryController.updateCategory(categoryRequest, 1L);

      assertNotNull(response);
      assertEquals(response.getBody(), categoryResponse);


   }
}