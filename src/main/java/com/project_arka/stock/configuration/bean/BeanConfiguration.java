package com.project_arka.stock.configuration.bean;

import com.project_arka.stock.domain.api.IBrandServicePort;
import com.project_arka.stock.domain.api.usecase.BrandUseCase;
import com.project_arka.stock.domain.spi.IBrandPersistencePort;
import com.project_arka.stock.ports.driven.jpa.mysql.adapter.BrandAdapter;
import com.project_arka.stock.ports.driven.jpa.mysql.mapper.IBrandEntityMapper;
import com.project_arka.stock.ports.driven.jpa.mysql.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@RequiredArgsConstructor
@Configuration
public class BeanConfiguration {

    private final IBrandEntityMapper brandEntityMapper;
    private final IBrandRepository brandRepository;

    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandAdapter(brandRepository, brandEntityMapper);
    }
   @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }
}