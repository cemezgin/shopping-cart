package com.app.service.delivery;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.service.cart.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostCalculatorTest {

    @Test
    public void test_deliveryCostShouldBeEqual()
    {
        DeliveryCostCalculator deliveryCostCalculator =
                new DeliveryCostCalculator(1, 1, 2.99);
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product,10);

        deliveryCostCalculator.calculateFor(testShoppingCart);

        assertEquals(4.99,testShoppingCart.getDeliveryCost());
    }

    @Test
    public void test_deliveryCostShouldBeEqualDifferentCost()
    {
        DeliveryCostCalculator deliveryCostCalculator =
                new DeliveryCostCalculator(30, 10, 2.99);
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product,10);

        deliveryCostCalculator.calculateFor(testShoppingCart);

        assertEquals(42.99,testShoppingCart.getDeliveryCost());
    }
}
