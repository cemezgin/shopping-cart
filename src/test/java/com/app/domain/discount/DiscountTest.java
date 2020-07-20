package com.app.domain.discount;

import com.app.domain.discount.type.Amount;
import com.app.domain.discount.type.DiscountType;
import com.app.domain.discount.type.Rate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscountTest {
    @Test
    public void test_discountSelectionShouldBeInstanceOfRate() {
        Discount discount = new Discount();
        assertTrue(discount.setDiscountType(DiscountType.Rate) instanceof Rate);
    }

    @Test
    public void test_discountSelectionShouldBeInstanceOfAmount() {
        Discount discount = new Discount();
        assertTrue(discount.setDiscountType(DiscountType.Amount) instanceof Amount);
    }
}
