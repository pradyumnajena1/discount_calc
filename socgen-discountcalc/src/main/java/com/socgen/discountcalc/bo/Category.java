package com.socgen.discountcalc.bo;

/**
 * Created By pradyumnakumarjena on 01/11/17 4:07 PM
 */
public class Category implements Discountable {


    private String categoryName;
    private Category parentCategory;


    private DiscountStrategy discountStrategy = new MinOfAllDiscountStrategy();
    private Discount discount;


    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, Category parentCategory) {
        this.categoryName = categoryName;
        this.parentCategory = parentCategory;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    @Override
    public Discountable getParent() {
        return getParentCategory();
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
