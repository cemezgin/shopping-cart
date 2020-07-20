package com.app.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartItemTest {
    private Category testCategory1 = new Category("TestCategory1");
    private Product testProduct1 = new Product("TestProduct1", 9999.99, testCategory1);
    private CartItem cartItem = new CartItem(testProduct1, 10);

    @Test
    public void test_GetProduct_Should_ReturnGivenProduct() {
        assertEquals(testProduct1, cartItem.getProduct());
    }

    @Test
    public void test_GetQuantity_Should_ReturnGivenQuantity() {
        assertEquals(10, cartItem.getQuantity());
    }

    @Test
    public void test_SetQuantity_Should_ReturnEditedQuantity() {
        cartItem.setQuantity(5);

        assertEquals(5, cartItem.getQuantity());
    }
}
