package com.project_arka.stock.ports.driven.jpa.mysql.repository;

import com.project_arka.stock.ports.driven.jpa.mysql.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    BrandEntity findByName(String name);
}
