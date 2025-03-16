package com.project_arka.stock.ports.driving.http.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project_arka.stock.domain.util.DomainConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierResponse {

    private Long nit;

    private String name;

    private String contactName;

    private String description;

    private String email;

    private String phone;

    private String address;

    private String website;
}
