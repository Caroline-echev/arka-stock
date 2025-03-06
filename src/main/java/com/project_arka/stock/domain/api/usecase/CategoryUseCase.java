package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.domain.exception.BrandAllreadyExistsException;
import com.project_arka.stock.domain.exception.CategoryAllreadyExistsException;
import com.project_arka.stock.domain.exception.EmptyBrandListException;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static com.project_arka.stock.domain.util.DomainConstants.BRAND_LIST_EMPTY_EXCEPTION_MESSAGE;
import static com.project_arka.stock.domain.util.DomainConstants.CATEGORY_ALREADY_EXISTS_EXCEPTION_MESSAGE;


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
            throw new EmptyBrandListException(BRAND_LIST_EMPTY_EXCEPTION_MESSAGE);
        }
        return sortCategories(categories, asc);
    }
    private List<Category> sortCategories(List<Category> categories, Boolean asc) {
        return categories.stream()
                .sorted(asc ? Comparator.comparing(Category::getName)
                        : Comparator.comparing(Category::getName).reversed())
                .toList();
    }
}
