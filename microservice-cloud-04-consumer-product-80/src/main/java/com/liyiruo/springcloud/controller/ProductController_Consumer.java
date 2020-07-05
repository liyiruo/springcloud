package com.liyiruo.springcloud.controller;

import com.liyiruo.springcloud.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 远程调用的类
 *
 * @author liyiruo
 */
@RestController
public class ProductController_Consumer {
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://microservice-product";
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试地址：
     * localhost/consumer/product/get/1
     *
     * @param id
     * @return
     */
    @GetMapping("consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {

        String url = REST_URL_PREFIX + "/product/get/" + id;

        return restTemplate.getForObject(url, Product.class);
    }


    @GetMapping("consumer/product/list")
    public List list() {
        String url = REST_URL_PREFIX + "/product/list";
        return restTemplate.getForObject(url, List.class);
    }

    @PostMapping("consumer/product/add")
    public Boolean add(@RequestBody Product product) {
        String url = REST_URL_PREFIX + "/product/add";
        return restTemplate.postForObject(url, product, Boolean.class);
    }

}
