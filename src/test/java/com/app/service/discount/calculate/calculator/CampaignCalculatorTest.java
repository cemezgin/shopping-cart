package com.app.service.discount.calculate.calculator;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.discount.Campaign;
import com.app.service.cart.ShoppingCart;
import com.app.service.discount.calculate.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignCalculatorTest {
    @Test
    public void test_campaignCalculateResultShouldBeZero() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Campaign campaign = new Campaign(category, 10, 15, DiscountType.Amount);

        testShoppingCart.applyDiscounts(campaign);

        assertEquals(0, testShoppingCart.getTotalCampaignDiscount());
    }

    @Test
    public void test_campaignCalculateResultShouldBeEqualAmount() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Campaign campaign = new Campaign(category, 10, 5, DiscountType.Amount);

        testShoppingCart.applyDiscounts(campaign);

        assertEquals(10, testShoppingCart.getTotalCampaignDiscount());
    }

    @Test
    public void test_campaignCalculateResultShouldBeEqualRateAndAmount() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Campaign campaign = new Campaign(category, 10, 5, DiscountType.Amount);
        Campaign campaign2 = new Campaign(category, 10, 5, DiscountType.Rate);

        testShoppingCart.applyDiscounts(campaign, campaign2);

        assertEquals(110, testShoppingCart.getTotalCampaignDiscount());
    }
}
