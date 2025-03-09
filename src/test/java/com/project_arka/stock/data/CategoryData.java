package com.project_arka.stock.data;


import com.project_arka.stock.domain.model.Category;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.CategoryEntity;
import com.project_arka.stock.ports.driving.http.dto.request.CategoryRequest;
import com.project_arka.stock.ports.driving.http.dto.response.CategoryResponse;

import java.util.List;

public class CategoryData {
    public static Category getCategory() {
        return new Category(1L, "Teclados", "Description");
    }

    public static List<Category> getCategoryList() {
        return List.of(
                new Category(1L, "Teclados", "Description"),
                new Category(2L, "Mouse", "Description"),
                new Category(3L, "Monitores" , "Description")
        );
    }

    public static CategoryResponse getCategoryResponse() {
        return new CategoryResponse(1L, "Teclados", "Description");
    }

    public static CategoryRequest getCategoryRequest() {
        return new CategoryRequest("Teclados", "Description");

    }

    public static CategoryEntity getCategoryEntity() {
        return new CategoryEntity(1L, "Teclados", "Description");
    }
}
