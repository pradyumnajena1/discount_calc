package com.socgen.discountcalc.bo;

/**
 * Created By pradyumnakumarjena on 01/11/17 5:15 PM
 */
public class Brand implements Discountable {


    private final String brandName;

    private Discount discount;
    private DiscountStrategy discountStrategy = new MinOfAllDiscountStrategy();

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    @Override
    public Discountable getParent() {
        return null;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }


}
