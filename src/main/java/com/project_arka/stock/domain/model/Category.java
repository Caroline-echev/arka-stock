package com.project_arka.stock.domain.model;


import com.project_arka.stock.domain.exception.badrequest.CategoryInvalidException;

import static com.project_arka.stock.domain.util.DomainConstants.*;

public class Category {
    private Long id;
    private String name;
    private String description;

    public Category(Long id, String name, String description) {
        this.id = id;
        setName(name);
        setDescription(description);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new CategoryInvalidException(CATEGORY_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
        if (name.length() > CATEGORY_NAME_MAX_LENGTH) {
            throw new CategoryInvalidException(CATEGORY_NAME_LENGTH_EXCEPTION_MESSAGE);
        }

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new CategoryInvalidException(CATEGORY_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE);
        }
        if (description.length() > CATEGORY_DESCRIPTION_MAX_LENGTH) {
            throw new CategoryInvalidException(CATEGORY_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE);
        }
        this.description = description;
    }
}