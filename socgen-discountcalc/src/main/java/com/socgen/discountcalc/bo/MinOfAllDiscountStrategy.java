package com.socgen.discountcalc.bo;

import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 4:42 PM
 */
public class MinOfAllDiscountStrategy implements DiscountStrategy {


    public Money getDiscount(Money... prices ) {

        Money result = null;

        for(Money price:prices){

            if(price!=null){
                if(result==null){
                    result = price;
                }
                else if(price.isLessThan(result)){
                    result = price;
                }
            }
        }

        return result;
    }
}
