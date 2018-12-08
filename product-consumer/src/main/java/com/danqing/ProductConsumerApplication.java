package com.danqing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.danqing")
@EnableEurekaClient
public class ProductConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductConsumerApplication.class, args);
    }

}
