package com.app.service.discount.calculate.calculator;

import com.app.entity.Category;
import com.app.entity.Product;
import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;
import com.app.service.discount.calculate.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CouponCalculatorTest {
    @Test
    public void test_couponCalculateResultShouldBeZero() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Coupon coupon = new Coupon(5000,20,DiscountType.Amount);
        testShoppingCart.applyCoupon(coupon);

        assertEquals(0, testShoppingCart.getTotalCouponDiscount());
    }

    @Test
    public void test_couponCalculateResultShouldBeEqualAmount() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Coupon coupon = new Coupon(1,10,DiscountType.Amount);

        testShoppingCart.applyCoupon(coupon);

        assertEquals(10, testShoppingCart.getTotalCouponDiscount());
    }

    @Test
    public void test_couponCalculateResultShouldBeEqualRate() {
        Category category = new Category("TestCategory");
        Product product = new Product("TestProduct", 100.0, category);
        ShoppingCart testShoppingCart = new ShoppingCart();
        testShoppingCart.addItem(product, 10);

        Coupon coupon = new Coupon(1,10,DiscountType.Rate);

        testShoppingCart.applyCoupon(coupon);

        assertEquals(100, testShoppingCart.getTotalCouponDiscount());
    }
}
