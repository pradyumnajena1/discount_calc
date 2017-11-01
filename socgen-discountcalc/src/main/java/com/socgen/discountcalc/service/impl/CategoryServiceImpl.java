package com.socgen.discountcalc.service.impl;

import com.socgen.discountcalc.bo.Category;
import com.socgen.discountcalc.bo.Discount;
import com.socgen.discountcalc.bo.DiscountStrategy;
import com.socgen.discountcalc.bo.MinOfAllDiscountStrategy;
import com.socgen.discountcalc.constants.Categories;
import com.socgen.discountcalc.dao.CategoryDao;
import com.socgen.discountcalc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By pradyumnakumarjena on 01/11/17 6:01 PM
 */

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {


    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public Category getCategory(String name) {
        return categoryDao.getCategory(name);
    }

    @Override
    public Category createCategory(String name) {
        return categoryDao.createCategory(name);
    }

    @Override
    public Category createCategory(Categories categories) {
        if(categories.getParent()!=null){
            return createCategory(categories.getCategoryName(),categories.getParent().getCategoryName());
        }
        return createCategory(categories.getCategoryName());
    }

    @Override
    public Category createCategory(String name, String parent) {
        return categoryDao.createCategory(name,parent);
    }

    @Override
    public void applyDiscount(String name, Discount discount){
        applyDiscount(name,discount,new MinOfAllDiscountStrategy());


    }
    @Override
    public void applyDiscount(String name, Discount discount, DiscountStrategy discountStrategy) {
        Category category = categoryDao.getCategory(name);
        category.setDiscount(discount);
        category.setDiscountStrategy(discountStrategy);
    }
}
