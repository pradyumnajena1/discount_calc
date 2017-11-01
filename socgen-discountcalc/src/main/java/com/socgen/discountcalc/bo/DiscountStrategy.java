package com.socgen.discountcalc.bo;

import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 4:41 PM
 */
public interface DiscountStrategy {

    Money getDiscount(Money... money);
}
