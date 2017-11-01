package com.socgen.discountcalc.bo;

import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 4:34 PM
 */
public class Product implements Discountable {

    private final long id;
    private final Brand brand;
    private final Category category;

    private final Money price;
    private DiscountStrategy discountStrategy= new MinOfAllDiscountStrategy();
    private Discount discount;


    public Product(long id, Brand brand,Category category, Money price) {
        this.id = id;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }


    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    @Override
    public Category getParent() {
        return category;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public Money getPrice() {
        return price;
    }

    public Money getDiscountedPrice(){

        return getDiscountedPrice(getPrice());
    }

    @Override
    public Money getDiscountedPrice(Money amount) {

        Money productDiscountedPrice = null;
        Discount discount = getDiscount();
        if(discount==null){
            productDiscountedPrice =  amount;
        }else {

              productDiscountedPrice = discount.getDiscountedPrice(amount);
        }


        Money categoryDiscountedPrice = null;
        if (getParent() != null) {
            categoryDiscountedPrice = getParent().getDiscountedPrice(amount);
        }

        Money brandDiscountedPrice  = getBrand().getDiscountedPrice(amount);


        return getDiscountStrategy().getDiscount(productDiscountedPrice, categoryDiscountedPrice,brandDiscountedPrice);


    }
}
