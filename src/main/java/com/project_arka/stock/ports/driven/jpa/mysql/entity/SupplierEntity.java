package com.project_arka.stock.ports.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project_arka.stock.domain.util.DomainConstants.*;
import static com.project_arka.stock.ports.driven.jpa.mysql.util.AdapterConstants.CONTACT_NAME;
import static com.project_arka.stock.ports.driven.jpa.mysql.util.AdapterConstants.TABLE_SUPPLIER;


@Entity
@Table(name = TABLE_SUPPLIER)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Long nit;

    @Column(nullable = false, unique = true, length = SUPPLIER_NAME_MAX_LENGTH)
    private String name;

    @Column(name = CONTACT_NAME, nullable = false, length = SUPPLIER_CONTACT_NAME_MAX_LENGTH)
    private String contactName;

    @Column(nullable = false, length = SUPPLIER_DESCRIPTION_MAX_LENGTH)
    private String description;

    @Column(nullable = false, unique = true, length = SUPPLIER_EMAIL_MAX_LENGTH)
    private String email;

    @Column(nullable = false, length = SUPPLIER_PHONE_MAX_LENGTH)
    private String phone;

    @Column(nullable = false, length = SUPPLIER_ADDRESS_MAX_LENGTH)
    private String address;

    @Column(length = SUPPLIER_WEBSITE_MAX_LENGTH)
    private String website;

}
