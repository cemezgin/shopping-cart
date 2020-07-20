package com.app.domain.discount;

import com.app.domain.discount.type.*;

public class Discount {
    public CalculateByTypeInterface setDiscountType(DiscountType discountType) {
        return select(discountType);
    }

    //@todo Implement for open-closed
    private CalculateByTypeInterface select(DiscountType discountType) {
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
