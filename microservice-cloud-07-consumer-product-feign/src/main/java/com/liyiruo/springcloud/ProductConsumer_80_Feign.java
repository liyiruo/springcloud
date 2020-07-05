package com.liyiruo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.liyiruo.springcloud")
@EnableEurekaClient
@SpringBootApplication
public class ProductConsumer_80_Feign {
    public static void main(String[] args) {
        SpringApplication.run(ProductConsumer_80_Feign.class,args);
    }
}
