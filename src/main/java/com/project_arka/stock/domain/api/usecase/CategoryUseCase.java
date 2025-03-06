package com.project_arka.stock.domain.api.usecase;

import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.domain.exception.BrandAllreadyExistsException;
import com.project_arka.stock.domain.exception.CategoryAllreadyExistsException;
import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;

import static com.project_arka.stock.domain.util.DomainConstants.BRAND_ALREADY_EXISTS_EXCEPTION_MESSAGE;
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
}
