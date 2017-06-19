package com.www.amaysim.factory;

import com.www.amaysim.entity.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsl-paolo on 19/06/2017.
 */
public class ProductFactory {

    private static Map<String, Product> productFactory;

    static {
        productFactory = new HashMap<String, Product>();
        productFactory.put("Unlimited 1GB", new Product("ult_small", "Unlimited 1GB", 24.90));
        productFactory.put("Unlimited 2GB", new Product("ult_medium", "Unlimited 2GB", 29.90));
        productFactory.put("Unlimited 5GB", new Product("ult_large", "Unlimited 5GB", 44.90));
        productFactory.put("1 GB Data-pack", new Product("1gb", "1 GB Data-pack", 9.90));
    }

    public static Product getProduct(String productName) {
        return productFactory.get(productName);
    }

}
