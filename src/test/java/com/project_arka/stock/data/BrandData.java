package com.project_arka.stock.data;
import com.project_arka.stock.domain.model.Brand;
import com.project_arka.stock.ports.driven.jpa.mysql.entity.BrandEntity;
import com.project_arka.stock.ports.driving.http.dto.request.BrandRequest;
import com.project_arka.stock.ports.driving.http.dto.response.BrandResponse;

import java.util.List;

public class BrandData {
    public static Brand getBrand() {
        return new Brand(1L, "Logitech", "Description");
    }

    public static List<Brand> getBrandList() {
        return List.of(
                new Brand(1L, "Logitech", "Description"),
                new Brand(2L, "Razer", "Description"),
                new Brand(3L, "Corsair", "Description")
        );
    }
    public static BrandRequest getBrandRequest() {
        return new BrandRequest("Logitech", "Description");
    }

    public static BrandResponse getBrandResponse() {
        return new BrandResponse(1L, "Logitech", "Description");
    }
    public static BrandEntity getBrandEntity() {
        return new BrandEntity(1L, "Logitech", "Description");
    }
}
