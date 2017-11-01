package com.socgen.discountcalc.service;

import com.socgen.discountcalc.bo.*;
import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 7:21 PM
 */
public interface ProductService {

    Product createProduct(long id, String brandName, String categoryName, Money price);
    Product getProduct(long id);
    void applyDiscount(long id, Discount discount) ;
    void applyDiscount(long id, Discount discount, DiscountStrategy discountStrategy) ;

    Money getTotalAmount(Bill bill);
}
