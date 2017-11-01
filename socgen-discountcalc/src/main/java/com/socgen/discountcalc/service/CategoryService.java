package com.socgen.discountcalc.service;

import com.socgen.discountcalc.bo.Category;
import com.socgen.discountcalc.bo.Discount;
import com.socgen.discountcalc.bo.DiscountStrategy;
import com.socgen.discountcalc.constants.Categories;

/**
 * Created By pradyumnakumarjena on 01/11/17 5:59 PM
 */
public interface CategoryService {

    Category createCategory(String name);
    Category createCategory(Categories categories);

    Category getCategory(String name);

    Category createCategory(String name, String parent);

    void applyDiscount(String name, Discount discount);
    void applyDiscount(String name, Discount discount,DiscountStrategy discountStrategy);

}
