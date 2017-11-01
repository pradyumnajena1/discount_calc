package com.socgen.discountcalc.bo;

import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 4:21 PM
 */
public interface Discountable {

    default Money getDiscountedPrice(Money amount) {

        Money discountedPrice = null;
        Discount discount = getDiscount();
        if(discount==null){
            discountedPrice = amount;
        }else {

              discountedPrice = discount.getDiscountedPrice(amount);
        }


        Money parentDiscountedPrice = null;
        if(getParent()==null){
            parentDiscountedPrice = amount;
        }else  {
            parentDiscountedPrice = getParent().getDiscountedPrice(amount);
        }
        return getDiscountStrategy().getDiscount(discountedPrice, parentDiscountedPrice);
    }


    DiscountStrategy getDiscountStrategy();

    Discountable getParent();

    Discount getDiscount();
}
