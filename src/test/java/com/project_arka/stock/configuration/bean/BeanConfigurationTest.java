package com.project_arka.stock.configuration.bean;

import com.project_arka.stock.domain.api.IBrandServicePort;
import com.project_arka.stock.domain.api.ICategoryServicePort;
import com.project_arka.stock.domain.api.usecase.BrandUseCase;
import com.project_arka.stock.domain.api.usecase.CategoryUseCase;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import com.project_arka.stock.domain.spi.ICategoryPersistencePort;
import com.project_arka.stock.ports.driven.jpa.mysql.adapter.BrandAdapter;
import com.project_arka.stock.ports.driven.jpa.mysql.adapter.CategoryAdapter;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.ICategoryEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.IBrandRepository;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class BeanConfigurationTest {

    @Mock
    private IBrandEntityMapper brandEntityMapper;
    @Mock
    private IBrandRepository brandRepository;
    @Mock
    private ICategoryRepository categoryRepository;
    @Mock
    private ICategoryEntityMapper categoryEntityMapper;

    @InjectMocks
    private BeanConfiguration beanConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBrandPersistencePort() {
        IBrandPersistencePort brandPersistencePort = beanConfiguration.brandPersistencePort();
        assertNotNull(brandPersistencePort);
        assert(brandPersistencePort instanceof BrandAdapter);
    }

    @Test
    void testBrandServicePort() {
        IBrandServicePort brandServicePort = beanConfiguration.brandServicePort();
        assertNotNull(brandServicePort);
        assert(brandServicePort instanceof BrandUseCase);
    }

    @Test
    void testCategoryPersistencePort() {
        ICategoryPersistencePort categoryPersistencePort = beanConfiguration.categoryPersistencePort();
        assertNotNull(categoryPersistencePort);
        assert(categoryPersistencePort instanceof CategoryAdapter);
    }

    @Test
    void testCategoryServicePort() {
        ICategoryServicePort categoryServicePort = beanConfiguration.categoryServicePort();
        assertNotNull(categoryServicePort);
        assert(categoryServicePort instanceof CategoryUseCase);
    }
}
