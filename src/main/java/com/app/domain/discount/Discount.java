package com.app.domain.discount;

import com.app.domain.discount.type.*;

import java.util.HashMap;

public class Discount {
    private final HashMap<DiscountType, CalculateByTypeInterface> selectDiscountType = new HashMap<>();

    public Discount() {
        selectDiscountType.put(DiscountType.Amount, new Amount());
        selectDiscountType.put(DiscountType.Rate, new Rate());
    }

    public CalculateByTypeInterface setDiscountType(DiscountType discountType) {
        return select(discountType);
    }

    private CalculateByTypeInterface select(DiscountType discountType) {
        return selectDiscountType.get(discountType);
    }
}
