package com.liyiruo.springcloud.controller;

import com.liyiruo.springcloud.entities.Product;
import com.liyiruo.springcloud.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyiruo
 */
@RestController
public class ProductController_Feign {
    @Autowired
    private ProductClientService service;

    @GetMapping("consumer/product/list")
    public List<Product> list() {
        return service.list();
    }

    @PostMapping("/consumer/product/add")
    public Boolean add(@RequestBody Product product) {
        return service.add(product);
    }

    @GetMapping("/consumer/product/{id}")
    public Product get(@PathVariable("id") Long id) {
        return service.get(id);
    }

}
