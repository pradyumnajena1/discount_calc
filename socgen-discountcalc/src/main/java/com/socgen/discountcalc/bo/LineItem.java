package com.socgen.discountcalc.bo;

/**
 * Created By pradyumnakumarjena on 01/11/17 9:59 PM
 */
public class LineItem {

    private final long productId;

    public LineItem(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }
}
