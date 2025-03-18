package com.project_arka.stock.domain.model;

import com.project_arka.stock.domain.exception.badrequest.SupplierInvalidException;
import lombok.Builder;

import static com.project_arka.stock.domain.util.DomainConstants.*;
@Builder
public class Supplier {

    private Long id;

    private Long nit;

    private String name;

    private String contactName;

    private String description;

    private String email;

    private String phone;

    private String address;
    private String website;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        if (nit == null || !String.valueOf(nit).matches(NUMBER_PATTERN)) {
            throw new SupplierInvalidException(SUPPLIER_NIT_PATTERN_EXCEPTION_MESSAGE);
        }
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new SupplierInvalidException(SUPPLIER_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
        if (name.length() > SUPPLIER_NAME_MAX_LENGTH) {
            throw new SupplierInvalidException(SUPPLIER_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        if (contactName == null || contactName.isEmpty()) {
            throw new IllegalArgumentException(SUPPLIER_CONTACT_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
        if (contactName.length() > SUPPLIER_CONTACT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(SUPPLIER_CONTACT_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.contactName = contactName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null && description.length() > SUPPLIER_DESCRIPTION_MAX_LENGTH) {
            throw new IllegalArgumentException(SUPPLIER_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE);
        }
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches(EMAIL_PATTERN)) {
            throw new IllegalArgumentException(SUPPLIER_EMAIL_PATTERN_EXCEPTION_MESSAGE);
        }
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches(PHONE_PATTERN)) {
            throw new IllegalArgumentException(SUPPLIER_PHONE_PATTERN_EXCEPTION_MESSAGE);
        }
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
