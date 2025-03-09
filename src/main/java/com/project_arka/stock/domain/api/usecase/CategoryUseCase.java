package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.domain.exception.*;
import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static com.project_arka.stock.domain.util.DomainConstants.*;


@RequiredArgsConstructor
public class CategoryUseCase implements ICategoryServicePort {

    private  final ICategoryPersistencePort categoryPersistencePort;

    @Override
    public Category createCategory(Category category) {
        if(categoryPersistencePort.findByName(category.getName()) != null)
            throw new CategoryAllreadyExistsException(CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE);
        return categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> findAllCategories(Boolean asc) {
        List<Category> categories = categoryPersistencePort.findAllCategories();
        if (categories == null || categories.isEmpty()) {
            throw new EmptyCategoryListException(CATEGORY_LIST_EMPTY_EXCEPTION_MESSAGE);
        }
        return sortCategories(categories, asc);
    }

    @Override
    public Category findCategoryById(Long id) {
        Category category = categoryPersistencePort.findCategoryById(id);
        if(category == null){
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        return category;
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        if(categoryPersistencePort.findCategoryById(id) == null){
            throw new CategoryNotFoundException(CATEGORY_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        category.setId(id);
        return categoryPersistencePort.saveCategory(category);
    }

    private List<Category> sortCategories(List<Category> categories, Boolean asc) {
        return categories.stream()
                .sorted(asc ? Comparator.comparing(Category::getName)
                        : Comparator.comparing(Category::getName).reversed())
                .toList();
    }
}
