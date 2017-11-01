package com.socgen.discountcalc.service;

import com.socgen.discountcalc.bo.Brand;
import com.socgen.discountcalc.bo.Discount;
import com.socgen.discountcalc.bo.DiscountStrategy;
import com.socgen.discountcalc.constants.Brands;

/**
 * Created By pradyumnakumarjena on 01/11/17 7:04 PM
 */
public interface BrandService {

    Brand getBrand(String brandName);
    Brand createBrand(String brandName);
    Brand createBrand(Brands brand);

    void applyDiscount(String name, Discount discount);
    void applyDiscount(String name, Discount discount,DiscountStrategy discountStrategy);

}
