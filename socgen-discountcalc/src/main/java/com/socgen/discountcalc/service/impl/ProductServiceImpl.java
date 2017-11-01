package com.socgen.discountcalc.service.impl;

import com.socgen.discountcalc.bo.*;
import com.socgen.discountcalc.dao.ProductDao;
import com.socgen.discountcalc.service.ProductService;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By pradyumnakumarjena on 01/11/17 7:24 PM
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {


    private final ProductDao productDao ;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public Product createProduct(long id, String brandName, String categoryName,Money price) {
        return productDao.createProduct(id,brandName,categoryName,price);
    }

    @Override
    public Product getProduct(long id) {
        return productDao.getProduct(id);
    }

    @Override
    public void applyDiscount(long id, Discount discount) {
        applyDiscount(id,discount,new MinOfAllDiscountStrategy());
    }

    @Override
    public void applyDiscount(long id,Discount discount, DiscountStrategy discountStrategy) {
        Product product = getProduct(id);
        product.setDiscount(discount);
        product.setDiscountStrategy(discountStrategy);

    }

    @Override
    public Money getTotalAmount(Bill bill) {

        List<LineItem> lineItems = bill.getLineItems();
        Money totalAmount = Money.of(0,"INR");
        for(LineItem aLineItem:lineItems){

            long productId = aLineItem.getProductId();
            Product product = getProduct(productId);
            Money discountedPrice = product.getDiscountedPrice();
            totalAmount = totalAmount.add(discountedPrice);

        }
        return totalAmount;
    }
}



