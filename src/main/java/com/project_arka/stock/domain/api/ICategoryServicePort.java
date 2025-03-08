package com.project_arka.stock.domain.api;

import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.model.Category;

import java.util.List;


public interface ICategoryServicePort {
    Category createCategory(Category category);
    List<Category> findAllCategories (Boolean asc);
    Category findCategoryById(Long id);

}
