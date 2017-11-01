package com.socgen.discountcalc.dao;

import com.socgen.discountcalc.bo.Product;
import org.javamoney.moneta.Money;

/**
 * Created By pradyumnakumarjena on 01/11/17 7:25 PM
 */
public interface ProductDao {

    Product getProduct(long id);
    Product createProduct(long id, String brandName, String category, Money price);
}
