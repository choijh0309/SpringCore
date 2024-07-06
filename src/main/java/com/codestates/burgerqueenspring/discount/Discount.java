package com.codestates.burgerqueenspring.discount;

import com.codestates.burgerqueenspring.discount.discountCondition.CozDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.DiscountCondition;
import com.codestates.burgerqueenspring.discount.discountCondition.KidDiscountCondition;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedAmountDiscountPolicy;
import com.codestates.burgerqueenspring.discount.discountPolicy.FixedRateDiscountPolicy;

public class Discount {

    private DiscountCondition[] discountConditions;

    public Discount(DiscountCondition[] discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Discount() {
    }

    public void checkAllDiscountConditions() {
        for (DiscountCondition discountCondition : discountConditions) {
            discountCondition.checkDiscountCondition();
        }
    }

    public int discount(int price) {

        int discountedPrice = price;

        for (DiscountCondition discountCondition : discountConditions) {
            if (discountCondition.isSatisfied()) discountedPrice = discountCondition.applyDiscount(discountedPrice);
        }

        return discountedPrice;
    }
}