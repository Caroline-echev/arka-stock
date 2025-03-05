package com.project_arka.stock.ports.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project_arka.stock.domain.util.DomainConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandRequest {


    @NotBlank(message = BRAND_NAME_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = BRAND_NAME_MAX_LENGTH, message = BRAND_NAME_LENGTH_EXCEPTION_MESSAGE)
    @Pattern(regexp = NAME_PATTERN, message = BRAND_NAME_NUMBER_EXCEPTION_MESSAGE)
    private String name;

    @NotBlank(message = BRAND_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = BRAND_DESCRIPTION_MAX_LENGTH, message = BRAND_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE)
    private String description;
}
