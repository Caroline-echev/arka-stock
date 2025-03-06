package com.project_arka.stock.ports.driven.jpa.mysql.repository;

import com.project_arka.stock.ports.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByName(String name);
}
