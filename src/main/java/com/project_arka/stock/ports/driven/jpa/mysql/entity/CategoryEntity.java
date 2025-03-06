package com.project_arka.stock.ports.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project_arka.stock.ports.driven.jpa.mysql.util.AdapterConstants.TABLE_BRAND;
import static com.project_arka.stock.ports.driven.jpa.mysql.util.AdapterConstants.TABLE_CATEGORY;


@Entity
@Table(name = TABLE_CATEGORY)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false, unique = true)
    private String name;

    @Column( nullable = false)
    private String description;
}
