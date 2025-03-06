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
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    private final IBrandEntityMapper brandEntityMapper;
    private final IBrandRepository brandRepository;
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandAdapter(brandRepository, brandEntityMapper);
    }
   @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }
}