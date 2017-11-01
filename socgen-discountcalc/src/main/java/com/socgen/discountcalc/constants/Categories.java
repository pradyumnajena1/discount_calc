package com.socgen.discountcalc.constants;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created By pradyumnakumarjena on 02/11/17 1:22 AM
 */
public enum Categories {

    MENS_WEAR("Men's wear"),
    WOMENS_WEAR("Women's wear"),


    SHIRTS("Shirts",MENS_WEAR),
    TROUSERS("Trousers",MENS_WEAR),
    CASUALS("Casuals",MENS_WEAR),
    JEANS("Jeans",MENS_WEAR),
    DRESSES("Dresses",WOMENS_WEAR),
    FOOTWEAR("Footwear",WOMENS_WEAR),
    ;

    private static Map<String,Categories> nameToTypeMap;
    private final String categoryName;
    private   Categories parent;


    static {
        nameToTypeMap =   Arrays.stream(Categories.values())
                .collect(Collectors.toMap(Categories::getCategoryName, Function.identity(),(o, o2) -> o2));
    }

    Categories(String name ) {
        this.categoryName = name;
    }
    Categories(String name,Categories parent) {
        this.categoryName = name;
        this.parent = parent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Categories getParent() {
        return parent;
    }

    public static Categories of(String name){
        return nameToTypeMap.get(name);
    }
}
