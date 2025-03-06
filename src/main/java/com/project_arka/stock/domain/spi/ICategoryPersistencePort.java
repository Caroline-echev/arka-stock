package com.project_arka.stock.domain.spi;

import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    Category saveCategory(Category category);
    Category findByName(String name);
    List<Category>  findAllCategories();
}
