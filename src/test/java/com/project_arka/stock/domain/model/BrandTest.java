package com.project_arka.stock.domain.model;

import com.project_arka.stock.domain.exception.badrequest.BrandInvalidException;
import org.junit.jupiter.api.Test;

import static com.project_arka.stock.domain.util.DomainConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class BrandTest {
    @Test
    void setName_ShouldThrowException_WhenNameIsNull() {
        Exception exception = assertThrows(BrandInvalidException.class, () -> new Brand(1L, null, "Valid Description"));
        assertEquals(BRAND_NAME_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setName_ShouldThrowException_WhenNameIsEmpty() {
        Exception exception = assertThrows(BrandInvalidException.class, () -> new Brand(1L, "", "Valid Description"));
        assertEquals(BRAND_NAME_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setName_ShouldThrowException_WhenNameExceedsMaxLength() {
        String longName = "a".repeat(101);
        Exception exception = assertThrows(BrandInvalidException.class, () -> new Brand(1L, longName, "Valid Description"));
        assertEquals(BRAND_NAME_LENGTH_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setDescription_ShouldThrowException_WhenDescriptionIsNull() {
        Exception exception = assertThrows(BrandInvalidException.class, () -> new Brand(1L, "Valid Name", null));
        assertEquals(BRAND_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setDescription_ShouldThrowException_WhenDescriptionIsEmpty() {
        Exception exception = assertThrows(BrandInvalidException.class, () -> new Brand(1L, "Valid Name", ""));
        assertEquals(BRAND_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setDescription_ShouldThrowException_WhenDescriptionExceedsMaxLength() {
        String longDescription = "a".repeat(256);
        Exception exception = assertThrows(BrandInvalidException.class, () -> new Brand(1L, "Valid Name", longDescription));
        assertEquals(BRAND_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE, exception.getMessage());
    }
    @Test
    void setName_ShouldThrowException_WhenNameContainsOnlyNumbers() {
        Exception exception = assertThrows(BrandInvalidException.class, () -> new Brand(1L, "12345", "Valid Description"));
        assertEquals(BRAND_NAME_NUMBER_EXCEPTION_MESSAGE, exception.getMessage());
    }

}