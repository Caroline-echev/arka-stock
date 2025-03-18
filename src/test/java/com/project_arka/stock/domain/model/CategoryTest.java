package com.project_arka.stock.domain.model;

import com.project_arka.stock.domain.exception.badrequest.CategoryInvalidException;
import org.junit.jupiter.api.Test;


import static com.project_arka.stock.domain.util.DomainConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void setName_ShouldThrowException_WhenNameIsNull() {
        Exception exception = assertThrows(CategoryInvalidException.class, () -> new Category(1L, null, "Description"));
        assertEquals(CATEGORY_NAME_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setName_ShouldThrowException_WhenNameIsEmpty() {
        Exception exception = assertThrows(CategoryInvalidException.class, () -> new Category(1L, "", "Valid Description"));
        assertEquals(CATEGORY_NAME_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setName_ShouldThrowException_WhenNameExceedsMaxLength() {
        String longName = "a".repeat(101);
        Exception exception = assertThrows(CategoryInvalidException.class, () -> new Category(1L, longName, "Valid Description"));
        assertEquals(CATEGORY_NAME_LENGTH_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setDescription_ShouldThrowException_WhenDescriptionIsNull() {
        Exception exception = assertThrows(CategoryInvalidException.class, () -> new Category(1L, "Valid Name", null));
        assertEquals(CATEGORY_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setDescription_ShouldThrowException_WhenDescriptionIsEmpty() {
        Exception exception = assertThrows(CategoryInvalidException.class, () -> new Category(1L, "Valid Name", ""));
        assertEquals(CATEGORY_DESCRIPTION_EMPTY_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    void setDescription_ShouldThrowException_WhenDescriptionExceedsMaxLength() {
        String longDescription = "a".repeat(256);
        Exception exception = assertThrows(CategoryInvalidException.class, () -> new Category(1L, "Valid Name", longDescription));
        assertEquals(CATEGORY_DESCRIPTION_LENGTH_EXCEPTION_MESSAGE, exception.getMessage());
    }
}
