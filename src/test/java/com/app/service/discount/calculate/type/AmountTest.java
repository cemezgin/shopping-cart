package com.app.service.discount.calculate.type;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.discount.Campaign;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmountTest {
    @Test
    public void test_discountShouldBeEqualCampaign() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Amount amount = new Amount();
        Campaign campaign = new Campaign(category, 10, 5, DiscountType.Amount);

        amount.setShoppingCart(testShoppingCart);
        amount.setCampaign(campaign);

        assertEquals(10, amount.applyDiscount());
    }

    @Test
    public void test_discountShouldBeEqualCoupon() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Amount amount = new Amount();
        Coupon coupon = new Coupon(10, 5, DiscountType.Amount);

        amount.setShoppingCart(testShoppingCart);
        amount.setCoupon(coupon);

        assertEquals(5, amount.applyDiscount());
    }
}
