package com.socgen.discountcalc.service.impl;

import com.socgen.discountcalc.bo.*;
import com.socgen.discountcalc.constants.Brands;
import com.socgen.discountcalc.dao.BrandDao;
import com.socgen.discountcalc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By pradyumnakumarjena on 01/11/17 7:05 PM
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {


    private final BrandDao brandDao;

    @Autowired
    public BrandServiceImpl(BrandDao brandDao) {
        this.brandDao = brandDao;
    }


    @Override
    public Brand getBrand(String brandName) {
        return brandDao.getBrand(brandName);
    }

    @Override
    public Brand createBrand(String brandName) {
        return brandDao.createBrand(brandName);
    }

    @Override
    public Brand createBrand(Brands brand) {
        return createBrand(brand.getBrandName());
    }

    @Override
    public void applyDiscount(String name, Discount discount){
        applyDiscount(name,discount,new MinOfAllDiscountStrategy());


    }
    @Override
    public void applyDiscount(String name, Discount discount,DiscountStrategy discountStrategy) {
        Brand brand  = brandDao.getBrand(name);
        brand.setDiscount(discount);
        brand.setDiscountStrategy(discountStrategy);
    }
}
