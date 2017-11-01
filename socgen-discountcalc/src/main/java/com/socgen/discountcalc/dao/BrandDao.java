package com.socgen.discountcalc.dao;

import com.socgen.discountcalc.bo.Brand;

/**
 * Created By pradyumnakumarjena on 01/11/17 6:08 PM
 */
public interface BrandDao {

    Brand createBrand(String brandName);

    Brand getBrand(String brandName );
}
