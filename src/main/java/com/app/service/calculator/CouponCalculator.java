package com.app.service.calculator;

import com.app.entity.discount.Coupon;
import com.app.service.cart.ShoppingCart;
import com.app.domain.discount.Discount;
import com.app.domain.discount.type.Calculate;

public class CouponCalculator implements ICalculator {
    private final ShoppingCart shoppingCart;
    private final Coupon coupon;

    public CouponCalculator(ShoppingCart shoppingCart, Coupon coupon) {
        this.shoppingCart = shoppingCart;
        this.coupon = coupon;
    }

    public void calculate() {
        if (coupon.getMinimumAmount() < shoppingCart.getTotalPrice()) {
            Discount discount = new Discount();
            Calculate calculate = new Calculate(discount.setDiscountType(coupon.getDiscountType()));
            calculate.setCoupon(coupon);
            calculate.setShoppingCart(shoppingCart);
            double finalDiscountAmount = calculate.applyDiscount();
            shoppingCart.setTotalCouponDiscount(shoppingCart.getTotalCouponDiscount() + finalDiscountAmount);
        }
    }
}