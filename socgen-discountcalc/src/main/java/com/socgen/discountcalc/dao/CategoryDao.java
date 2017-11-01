package com.socgen.discountcalc.dao;

import com.socgen.discountcalc.bo.Category;

/**
 * Created By pradyumnakumarjena on 01/11/17 6:02 PM
 */
public interface CategoryDao {

    Category createCategory(String categoryName);

    Category createCategory(String categoryName, String parentCategoryName);

    Category getCategory(String categoryName);

}
