package com.danqing;

import com.danqing.product.Product;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
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
