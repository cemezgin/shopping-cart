package com.app.entity.discount;

import com.app.entity.Category;
import com.app.domain.discount.type.DiscountType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignTest {
    Category testCategory = new Category("TestCategory");
    Campaign testCampaign = new Campaign(testCategory,10,3, DiscountType.Amount);
    Campaign testCampaign2 = new Campaign(testCategory,5,20, DiscountType.Rate);

    @Test
    public void test_getDiscountShouldBeGiven()
    {
        assertEquals(10, testCampaign.getDiscount());
        assertEquals(5, testCampaign2.getDiscount());
    }

    @Test
    public void test_getMinimumItemShouldBeGiven()
    {
        assertEquals(3, testCampaign.getMinimumItem());
        assertEquals(20, testCampaign2.getMinimumItem());
    }

    @Test
    public void test_getDiscountTypeShouldBeGiven()
    {
        assertEquals(DiscountType.Rate, testCampaign2.getDiscountType());
        assertEquals(DiscountType.Amount, testCampaign.getDiscountType());
    }

}
