package com.danqing;

import com.danqing.product.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "PRODUCT-SERVICE",fallback = ProductServiceFallBack.class)
public interface ProductService {

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    List<Product> findAll();

    @RequestMapping(value = "/products/{itemCode}", method = RequestMethod.GET)
    Product loadByItemCode(@PathVariable("itemCode") String itemCode);

}
