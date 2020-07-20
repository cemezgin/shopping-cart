package com.app.domain.discount.type;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RateTest {
    @Test
    public void test_discountShouldBeEqualCampaign() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Rate rate = new Rate();
        Campaign campaign = new Campaign(category, 10, 5, DiscountType.Rate);

        rate.setShoppingCart(testShoppingCart);
        rate.setCampaign(campaign);

        assertEquals(100, rate.applyDiscount());
    }

    @Test
    public void test_discountShouldBeEqualCoupon() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Rate rate = new Rate();
        Coupon coupon = new Coupon(10, 5, DiscountType.Amount);

        rate.setShoppingCart(testShoppingCart);
        rate.setCoupon(coupon);

        assertEquals(50, rate.applyDiscount());
    }
}
