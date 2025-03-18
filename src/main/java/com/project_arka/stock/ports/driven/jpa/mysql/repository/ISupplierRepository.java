package com.project_arka.stock.ports.driven.jpa.mysql.repository;

import com.project_arka.stock.ports.driven.jpa.mysql.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepository  extends JpaRepository<SupplierEntity, Long> {
    SupplierEntity findByName(String name);
    SupplierEntity findByEmail(String email);
    SupplierEntity findByNit(Long nit);

}

