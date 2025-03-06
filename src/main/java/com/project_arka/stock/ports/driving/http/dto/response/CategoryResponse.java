package com.project_arka.stock.ports.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
}
