package com.socgen.discountcalc.dao.impl;

import com.socgen.discountcalc.bo.Brand;
import com.socgen.discountcalc.bo.Category;
import com.socgen.discountcalc.bo.Product;
import com.socgen.discountcalc.dao.BrandDao;
import com.socgen.discountcalc.dao.CategoryDao;
import com.socgen.discountcalc.dao.ProductDao;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By pradyumnakumarjena on 01/11/17 7:25 PM
 */
@Repository
public class ProductDaoImpl implements ProductDao{


    private final Map<Long,Product> productMap = new HashMap<>();


    private final BrandDao brandDao ;
    private CategoryDao categoryDao;

    @Autowired
    public ProductDaoImpl(BrandDao brandDao,CategoryDao categoryDao) {
        this.brandDao = brandDao;
        this.categoryDao = categoryDao;
    }


    @Override
    public Product getProduct(long id) {
        return productMap.get(id);
    }

    @Override
    public Product createProduct(long id, String brandName,String categoryName, Money price) {
        Brand brand = brandDao.getBrand(brandName);
        Category category = categoryDao.getCategory(categoryName);

        Product product = new Product(id,brand,category,price);
      productMap.put(id,product);
        return product;
    }
}
