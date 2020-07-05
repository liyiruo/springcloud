package com.liyiruo.springcloud.controller;

import com.liyiruo.springcloud.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 远程调用的类
 *
 * @author liyiruo
 */
@RestController
public class ProductController_Consumer {
    private static final String REST_URL_PREFIX = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;



    /**
     * 测试地址：
     * localhost/consumer/product/get/1
     * @param id
     * @return
     */
    @GetMapping("consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {

        String url = REST_URL_PREFIX + "/product/get/" + id;

        return restTemplate.getForObject(url, Product.class);
    }

}
