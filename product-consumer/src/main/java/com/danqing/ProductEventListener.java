package com.danqing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.danqing.product.Product;
import com.danqing.product.ProductEvent;

@Component
public class ProductEventListener implements ApplicationListener<ProductEvent> {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ProductService productService;

    @Override
    public void onApplicationEvent(ProductEvent productEvent) {
        if (ProductEvent.ET_UPDATE.equalsIgnoreCase(productEvent.getAction())) {
            this.logger.info("Web微服务收到商品变更事件，商品货号: {}", productEvent.getItemCode());
            // 重新获取该商品信息
            Product productDto = this.productService.loadByItemCode(productEvent.getItemCode());
            if (null != productDto)
                this.logger.info("重新获取到的商品信息为:{}", productDto);
            else
                this.logger.info("货号为:{} 的商品不存在", productEvent.getItemCode());
        } else if (ProductEvent.ET_DELETE.equalsIgnoreCase(productEvent.getAction())) {
            this.logger.info("Web微服务收到商品删除事件，所要删除商品货号为: {}", productEvent.getItemCode());
        } else {
            this.logger.info("Web微服务收到未知商品事件: {}", productEvent);
        }
    }
}

