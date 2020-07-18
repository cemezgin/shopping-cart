package com.app.service.discount.calculate;

import com.app.entity.Campaign;
import com.app.service.discount.calculate.campaign.*;

public class Discount {

    public ICalculateByType selectCampaignType(Campaign campaign) {
        switch (campaign.getDiscountType()) {
            case Rate:
                return new Rate(campaign);
            case Amount:
                return new Amount(campaign);
            default:
                return null;
        }
    }
}
