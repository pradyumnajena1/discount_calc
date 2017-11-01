package com.socgen.discountcalc;

import com.socgen.discountcalc.bo.*;
import com.socgen.discountcalc.config.ApplicationConfig;
import com.socgen.discountcalc.constants.Brands;
import com.socgen.discountcalc.constants.Categories;
import com.socgen.discountcalc.constants.DiscountType;
import com.socgen.discountcalc.service.BrandService;
import com.socgen.discountcalc.service.CategoryService;
import com.socgen.discountcalc.service.ProductService;
import org.javamoney.moneta.Money;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created By pradyumnakumarjena on 01/11/17 7:34 PM
 */
public class Main {




    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        CategoryService categoryService = (CategoryService) applicationContext.getBean("categoryService");
        ProductService productService = (ProductService) applicationContext.getBean("productService");
        BrandService brandService = (BrandService) applicationContext.getBean("brandService");

        initCategories(categoryService);

        initBrands(brandService);

        Scanner scanner = new Scanner(System.in);

        List<Product> products = createProducts(productService, scanner);

        List<Bill> bills = readBills(scanner);
        scanner.close();

        for(Bill aBill:bills){

           System.out.println(productService.getTotalAmount(aBill));
       }





    }

    private static List<Bill> readBills(Scanner scanner) {

        List<Bill> bills = new ArrayList<>();

        if(scanner.hasNextLine()){

            int numBills = readNextIntLIne(scanner);
            for(int i=0;i<numBills;i++){
                Bill bill = new Bill();
                String productsString = scanner.nextLine();
                String[] productIds  = productsString.split(",");
                for(String productId:productIds){
                    bill.addLineItem(new LineItem(Long.parseLong(productId)));
                }


                bills.add(bill);
            }

        }
        return bills;
    }



    private static List<Product> createProducts(ProductService productService, Scanner scanner) {

        List<Product> products = new ArrayList<>();

        if(scanner.hasNextLine()){
            int numProducts = readNextIntLIne(scanner);
            for(int i=0;i<numProducts;i++){
                String productString = scanner.nextLine();
                List<String> tokens = getStringTokens(productString);
                long productId = Long.parseLong(tokens.get(0));
                String brand = tokens.get(1);
                String category = tokens.get(2);
                double price = Double.parseDouble(tokens.get(3));
                Product product = productService.createProduct(productId, brand, category, Money.of(price, "INR"));
                products.add(product);
            }
        }
        return products;
    }



    private static void initBrands(BrandService brandService) {

        for(Brands brands:Brands.values()){

            brandService.createBrand(brands);
        }


        brandService.applyDiscount(Brands.WRANGLER.getBrandName(),new Discount(DiscountType.PERCENTAGE,10));
        brandService.applyDiscount(Brands.ARROW.getBrandName(),new Discount(DiscountType.PERCENTAGE,20));
        brandService.applyDiscount(Brands.VERO_MODA.getBrandName(),new Discount(DiscountType.PERCENTAGE,60));
        brandService.applyDiscount(Brands.ADIDAS.getBrandName(),new Discount(DiscountType.PERCENTAGE,5));
        brandService.applyDiscount(Brands.PROVOGUE.getBrandName(),new Discount(DiscountType.PERCENTAGE,20));

    }

    private static void initCategories(CategoryService categoryService) {
        categoryService.createCategory(Categories.MENS_WEAR);
        categoryService.createCategory(Categories.WOMENS_WEAR);

        categoryService.createCategory(Categories.SHIRTS );
        categoryService.createCategory(Categories.TROUSERS );
        categoryService.createCategory(Categories.CASUALS );
        categoryService.createCategory(Categories.JEANS );


        categoryService.createCategory(Categories.DRESSES );
        categoryService.createCategory(Categories.FOOTWEAR);


        categoryService.applyDiscount(Categories.WOMENS_WEAR.getCategoryName(),new Discount(DiscountType.PERCENTAGE,50));
        categoryService.applyDiscount(Categories.CASUALS.getCategoryName(),new Discount(DiscountType.PERCENTAGE,30));
        categoryService.applyDiscount(Categories.JEANS.getCategoryName(),new Discount(DiscountType.PERCENTAGE,20));

    }

    private static int readNextIntLIne(Scanner scanner) {
        String line = null;
        while (true){

            line = scanner.nextLine();
            line = line.trim();
            if(!line.equals("")){
                break;
            }
        }


        return Integer.parseInt(line);
    }

    private static List<String> getStringTokens(String productString) {

        return Arrays.stream(productString.split(",")).map(String::trim).collect(Collectors.toList());
    }


}
