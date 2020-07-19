package com.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CategoryTest {
    Category testParentCategory = new Category("TestParentCategory");
    Category testChildCategory = new Category("TestChildCategory", testParentCategory);

    @Test
    public void test_getTitleShouldReturnSameWithGiven() {
        assertEquals("TestParentCategory", testParentCategory.getTitle());
        assertEquals("TestChildCategory", testChildCategory.getTitle());
    }

    @Test
    public void test_parentCategory() {
        assertEquals(testChildCategory.getParentCategory(), testParentCategory);
        assertNull(testParentCategory.getParentCategory());
    }


}
