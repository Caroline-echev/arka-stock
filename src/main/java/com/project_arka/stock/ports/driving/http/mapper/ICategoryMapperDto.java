package com.project_arka.stock.ports.driving.http.mapper;


import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.ports.driving.http.dto.request.CategoryRequest;
import com.project_arka.stock.ports.driving.http.dto.response.CategoryResponse;
import org.mapstruct.Mapper;

import static com.project_arka.stock.ports.driving.http.util.ApplicationConstants.SPRING_MAPPING;


@Mapper(componentModel = SPRING_MAPPING)
public interface ICategoryMapperDto {
   CategoryResponse categoryToCategoryResponse(Category category);
   Category categoryRequestToCategory(CategoryRequest categoryRequest);
}
