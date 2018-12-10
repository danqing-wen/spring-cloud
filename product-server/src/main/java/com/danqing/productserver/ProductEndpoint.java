package com.danqing.productserver;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danqing.product.Product;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {
    protected Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return productService.buildProducts();
    }

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
    public Product detail(@PathVariable String itemCode) {
        List<Product> products = productService.buildProducts();
        for (Product product : products) {
            if (product.getItemCode().equalsIgnoreCase(itemCode))
                return product;
        }
        return null;
    }

    @RequestMapping(value = "/{itemCode}", method = RequestMethod.POST)
    public Product save(@PathVariable String itemCode) {
        List<Product> products = productService.buildProducts();
        Product product = productService.findOne(itemCode);
        if (product != null) {
            productService.save(product);
        }
        return product;
    }

}

