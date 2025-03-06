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
public class CategoryRequest {


    @NotBlank(message = CATEGORY_NAME_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = CATEGORY_NAME_MAX_LENGTH, message = CATEGORY_NAME_LENGTH_EXCEPTION_MESSAGE)
    @Pattern(regexp = NAME_PATTERN, message = CATEGORY_NAME_NUMBER_EXCEPTION_MESSAGE)
    private String name;

    @NotBlank(message = CATEGORY_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = CATEGORY_DESCRIPTION_MAX_LENGTH, message = CATEGORY_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE)
    private String description;
}
