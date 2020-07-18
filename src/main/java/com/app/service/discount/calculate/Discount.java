package com.app.service.discount.calculate;

import com.app.service.discount.calculate.type.*;

public class Discount {

    public ICalculateByType setDiscountType(DiscountType discountType) {
        return select(discountType);
    }

    private ICalculateByType select(DiscountType discountType) {
        switch (discountType) {
            case Rate:
                return new Rate();
            case Amount:
                return new Amount();
            default:
                return null;
        }
    }
}
