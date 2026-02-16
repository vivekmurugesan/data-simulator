package com.test.datasim.util;

import com.test.datasim.Product;
import com.test.datasim.ProductRepository;

import java.util.Random;

public class ProductDataUtil {
    public static void generate(ProductRepository repository){
        Random rand = new Random();
        for(int i=0;i<100;i++) {
            repository.save(new Product(randCat(rand), StringUtil.randString(), rand.nextInt(5000)));
        }
    }

    private static Product.ProductCategory randCat(Random rand){
        int randInt = rand.nextInt(2);
        Product.ProductCategory result;
        switch (randInt){
            case 0:
                result = Product.ProductCategory.apparel;
                break;
            case 1:
                result = Product.ProductCategory.book;
                break;
            case 2:
                result = Product.ProductCategory.electroinc;
                break;
            default:
                result = Product.ProductCategory.book;
                break;
        }
        return result;
    }
}
