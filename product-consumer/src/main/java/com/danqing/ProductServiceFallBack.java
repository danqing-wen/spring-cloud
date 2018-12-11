package com.danqing;

import java.util.Collections;
import java.util.List;

import com.danqing.product.Product;

//@Component
public class ProductServiceFallBack implements  ProductService {
    @Override
    public List<Product> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Product loadByItemCode(String itemCode) {
        return new Product("error", "未知", "hystrix-Fallback", 0);
    }
}
