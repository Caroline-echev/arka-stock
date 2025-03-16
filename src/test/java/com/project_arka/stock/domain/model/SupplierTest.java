package com.project_arka.stock.domain.model;

import com.project_arka.stock.domain.exception.badrequest.SupplierInvalidException;
import org.junit.jupiter.api.Test;

import static com.project_arka.stock.domain.util.DomainConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class SupplierTest {

    @Test
    void validSupplierShouldBeCreatedSuccessfully() {
        Supplier supplier = Supplier.builder()
                .id(1L)
                .nit(1234567890L)
                .name("Valid Name")
                .contactName("Contact Person")
                .description("Valid description")
                .email("test@example.com")
                .phone("+573001112233")
                .address("123 Main St")
                .website("https://example.com")
                .build();

        assertDoesNotThrow(() -> supplier.setNit(1234567890L));
        assertDoesNotThrow(() -> supplier.setName("Another Name"));
        assertDoesNotThrow(() -> supplier.setContactName("New Contact"));
        assertDoesNotThrow(() -> supplier.setDescription("Some description"));
        assertDoesNotThrow(() -> supplier.setEmail("valid@email.com"));
        assertDoesNotThrow(() -> supplier.setPhone("+573001234567"));
        assertDoesNotThrow(() -> supplier.setAddress("New Address"));
        assertDoesNotThrow(() -> supplier.setWebsite("https://newsite.com"));
    }



    @Test
    void setName_shouldThrowException_whenEmptyOrTooLong() {
        Supplier supplier = Supplier.builder().build();
        assertThrows(SupplierInvalidException.class, () -> supplier.setName(null));
        assertThrows(SupplierInvalidException.class, () -> supplier.setName(""));
        assertThrows(SupplierInvalidException.class, () -> supplier.setName("A".repeat(SUPPLIER_NAME_MAX_LENGTH + 1)));
    }

    @Test
    void setContactName_shouldThrowException_whenEmptyOrTooLong() {
        Supplier supplier = Supplier.builder().build();
        assertThrows(IllegalArgumentException.class, () -> supplier.setContactName(null));
        assertThrows(IllegalArgumentException.class, () -> supplier.setContactName(""));
        assertThrows(IllegalArgumentException.class, () -> supplier.setContactName("A".repeat(SUPPLIER_CONTACT_NAME_MAX_LENGTH + 1)));
    }

    @Test
    void setDescription_shouldThrowException_whenTooLong() {
        Supplier supplier = Supplier.builder().build();
        assertThrows(IllegalArgumentException.class, () -> supplier.setDescription("A".repeat(SUPPLIER_DESCRIPTION_MAX_LENGTH + 1)));
    }

    @Test
    void setEmail_shouldThrowException_whenInvalid() {
        Supplier supplier = Supplier.builder().build();
        assertThrows(IllegalArgumentException.class, () -> supplier.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> supplier.setEmail("invalid-email"));
    }

    @Test
    void setPhone_shouldThrowException_whenInvalid() {
        Supplier supplier = Supplier.builder().build();
        assertThrows(IllegalArgumentException.class, () -> supplier.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> supplier.setPhone("123abc"));
    }
}
