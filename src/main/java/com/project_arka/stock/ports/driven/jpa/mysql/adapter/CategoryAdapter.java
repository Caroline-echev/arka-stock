package com.project_arka.stock.ports.driven.jpa.mysql.adapter;


import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.domain.spi.ICategoryPersistencePort;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public Category saveCategory(Category category) {
        return categoryEntityMapper.categoryEntityToCategory(categoryRepository.save(categoryEntityMapper.categoryToCategoryEntity(category)));
    }

    @Override
    public Category findByName(String name) {
        return categoryEntityMapper.categoryEntityToCategory(categoryRepository.findByName(name));
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll().stream().map(categoryEntityMapper::categoryEntityToCategory).toList();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryEntityMapper.categoryEntityToCategory(categoryRepository.findById(id).orElse(null));
    }

}
