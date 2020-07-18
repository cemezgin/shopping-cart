package com.app.service.discount.calculate.calculator;

import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;
import com.app.service.discount.calculate.Discount;
import com.app.service.discount.calculate.type.Calculate;

public class CouponCalculator implements ICalculator{
    private final ShoppingCart shoppingCart;
    private final Coupon coupon;

    public CouponCalculator(ShoppingCart shoppingCart, Coupon coupon) {
        this.shoppingCart = shoppingCart;
        this.coupon = coupon;
    }

    public void calculate() {
        if (coupon.getMinimumAmount() > shoppingCart.getTotalPrice()) {
            Discount discount = new Discount();
            Calculate calculate = new Calculate(discount.setDiscountType(coupon.getDiscountType()));
            calculate.setCoupon(coupon);
            calculate.setShoppingCart(shoppingCart);
            calculate.applyDiscount();
        }
    }
}