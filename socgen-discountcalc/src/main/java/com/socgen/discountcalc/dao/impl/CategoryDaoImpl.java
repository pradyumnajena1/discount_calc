package com.socgen.discountcalc.dao.impl;

import com.socgen.discountcalc.bo.Category;
import com.socgen.discountcalc.dao.CategoryDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By pradyumnakumarjena on 01/11/17 5:24 PM
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private final Map<String, Category> categoryMap = new HashMap<>();


    @Override
    public Category createCategory(String categoryName){
        Category category = new Category(categoryName);
        categoryMap.put(categoryName, category);
        return category;
    }

    @Override
    public Category createCategory(String categoryName, String parentCategoryName) {



        Category parent = getCategory(parentCategoryName);


        Category category = new Category(categoryName, parent);
        categoryMap.put(categoryName, category);
        return category;
    }


    @Override
    public Category getCategory(String categoryName) {

            return categoryMap.get(categoryName);


    }





}
