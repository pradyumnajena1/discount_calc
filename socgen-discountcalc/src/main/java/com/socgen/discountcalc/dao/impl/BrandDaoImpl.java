package com.socgen.discountcalc.dao.impl;

import com.socgen.discountcalc.bo.Brand;
import com.socgen.discountcalc.dao.BrandDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By pradyumnakumarjena on 01/11/17 5:34 PM
 */
@Repository
public class BrandDaoImpl implements BrandDao {


    private final Map<String, Brand> brandMap = new HashMap<>();

     @Override
     public Brand createBrand(String brandName){

         Brand brand = new Brand(brandName);
         brandMap.put(brandName, brand);
         return brand;
     }


    @Override
    public   Brand getBrand(String brandName) {


            return brandMap.get(brandName);


    }
}
