package com.socgen.discountcalc.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By pradyumnakumarjena on 01/11/17 9:59 PM
 */
public class Bill {


    private final List<LineItem> lineItems;

    public Bill() {
        lineItems = new ArrayList<>();
    }

    //defensive copy
    public Bill(List<LineItem> lineItems) {
        if(lineItems==null){
            lineItems = new ArrayList<>();
        }
        this.lineItems = new ArrayList<>(lineItems);
    }

    public void addLineItem(LineItem lineItem){
        lineItems.add(lineItem);
    }

    public List<LineItem> getLineItems() {
        return new ArrayList<>(lineItems);
    }
}
