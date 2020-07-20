package com.app.entity.discount;

import com.app.domain.discount.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CouponTest {
    Coupon testCoupon = new Coupon(10,3.6, DiscountType.Amount);
    Coupon testCoupon2 = new Coupon(5,22.5, DiscountType.Rate);

    @Test
    public void test_getDiscountShouldBeGiven()
    {
        assertEquals(3.6, testCoupon.getDiscount());
        assertEquals(22.5, testCoupon2.getDiscount());
    }

    @Test
    public void test_getMinimumAmountShouldBeGiven()
    {
        assertEquals(10, testCoupon.getMinimumAmount());
        assertEquals(5, testCoupon2.getMinimumAmount());
    }

    @Test
    public void test_getDiscountTypeShouldBeGiven()
    {
        assertEquals(DiscountType.Amount, testCoupon.getDiscountType());
        assertEquals(DiscountType.Rate, testCoupon2.getDiscountType());
    }

}
