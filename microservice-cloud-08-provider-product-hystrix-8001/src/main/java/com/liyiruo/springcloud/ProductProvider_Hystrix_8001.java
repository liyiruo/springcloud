package com.liyiruo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 熔断是怎么实现的，
 * 1。首先加入eureka
 * 2。添加依赖
 * 3。controller 方法上 添加@HystrixCommand(fallbackMethod = "getFallback")
 * 4。添加调用的方法
 * 5。启动类添加注解 @EnableHystrix
 * @author liyiruo
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@MapperScan("com.liyiruo.springcloud.mapper")
public class ProductProvider_Hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_Hystrix_8001.class, args);
    }
}
