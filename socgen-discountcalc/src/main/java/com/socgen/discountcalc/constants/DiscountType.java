package com.socgen.discountcalc.constants;

import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 4:39 PM
 */
public enum DiscountType {

    FIXED {
        public Money getDiscountedPrice(Money actualPrice, int discountAmount) {
            return actualPrice.subtract(Money.of(discountAmount, "IND"));
        }
    }, PERCENTAGE {
        public Money getDiscountedPrice(Money actualPrice, int discountPercentage) {


            double multiplicand = (double) discountPercentage / 100;
            Money discount = actualPrice.multiply(multiplicand);
            return actualPrice.subtract(discount);
        }
    };


    public abstract Money getDiscountedPrice(Money actualPrice, int discountAmount);
}
