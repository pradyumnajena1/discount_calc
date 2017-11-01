package com.socgen.discountcalc.constants;

/**
 * Created By pradyumnakumarjena on 02/11/17 1:44 AM
 */
public enum Brands {

    WRANGLER("Wrangler"),
    ARROW("Arrow"),
    VERO_MODA("Vero Moda"),
    UCB("UCB"),
    ADIDAS("Adidas"),
    PROVOGUE("Provogue"),
    ;

    private final String brandName;

    Brands(String name) {
        this.brandName = name;
    }

    public String getBrandName() {
        return brandName;
    }
}
