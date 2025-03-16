package com.project_arka.stock.ports.driving.http.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.project_arka.stock.domain.util.DomainConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SupplierRequest {

    @NotNull(message = SUPPLIER_NIT_EMPTY_EXCEPTION_MESSAGE)
    private Long nit;

    @NotBlank(message = SUPPLIER_NAME_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = SUPPLIER_NAME_MAX_LENGTH, message = SUPPLIER_NAME_LENGTH_EXCEPTION_MESSAGE)
    private String name;

    @NotBlank(message = SUPPLIER_CONTACT_NAME_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = SUPPLIER_CONTACT_NAME_MAX_LENGTH, message = SUPPLIER_CONTACT_NAME_LENGTH_EXCEPTION_MESSAGE)
    private String contactName;

    @NotBlank(message = SUPPLIER_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = SUPPLIER_DESCRIPTION_MAX_LENGTH, message = SUPPLIER_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE)
    private String description;

    @NotBlank(message = SUPPLIER_EMAIL_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = SUPPLIER_EMAIL_MAX_LENGTH, message = SUPPLIER_EMAIL_LENGTH_EXCEPTION_MESSAGE)
    private String email;

    @NotBlank(message = SUPPLIER_PHONE_EMPTY_EXCEPTION_MESSAGE)
    @Size(max = SUPPLIER_PHONE_MAX_LENGTH, message = SUPPLIER_PHONE_LENGTH_EXCEPTION_MESSAGE)
    @Pattern(regexp = PHONE_PATTERN, message = SUPPLIER_PHONE_PATTERN_EXCEPTION_MESSAGE)
    private String phone;

    @Valid
    private AddressRequest address;

    @Size(max = SUPPLIER_WEBSITE_MAX_LENGTH, message = SUPPLIER_WEBSITE_LENGTH_EXCEPTION_MESSAGE)
    private String website;
}
