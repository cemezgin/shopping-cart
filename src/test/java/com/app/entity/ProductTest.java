package com.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    private final Category category = new Category("TestCategory");
    Product product = new Product("Test Product", 12.99, category);

    @Test
    public void test_getTitleShouldReturnSameWithGiven() {
        assertEquals("Test Product", product.getTitle());
    }

    @Test
    public void test_getPriceShouldReturnSameWithGiven() {
        assertEquals(12.99, product.getPrice());
    }

    @Test
    public void test_getCategoryShouldReturnSameWithGiven() {
        assertEquals(category, product.getCategory());
    }
}
