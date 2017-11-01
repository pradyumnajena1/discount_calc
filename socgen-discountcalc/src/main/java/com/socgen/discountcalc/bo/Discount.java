package com.socgen.discountcalc.bo;

import com.socgen.discountcalc.constants.DiscountType;
import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 4:47 PM
 */
public class Discount {

    private final DiscountType discountType;
    private final int amount;

    public Discount(DiscountType discountType, int amount) {
        this.discountType = discountType;
        this.amount = amount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public int getAmount() {
        return amount;
    }

    public Money getDiscountedPrice(Money actualPrice) {
        return discountType.getDiscountedPrice(actualPrice, amount);
    }
}
