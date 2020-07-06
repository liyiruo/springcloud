package com.liyiruo.springcloud.controller;

import com.liyiruo.springcloud.entities.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.liyiruo.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author liyiruo
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/add")
    public boolean add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/product/list")
    public List<Product> list() {
        return productService.list();
    }


    @GetMapping("/product/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Product get(@PathVariable("id") Long id) {
        Product product = productService.get(id);
        System.out.println(product == null);
        if (Objects.isNull(product)) {
            System.out.println("this is something wrong");
            throw new RuntimeException("id 不合法");
        }
        System.out.println("==========");
        return product;
    }

    /**
     * 当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
     *
     * @param id
     * @return Product
     */
    public Product getFallback(@PathVariable("id") Long id) {
        System.out.println("id===>"+id);
        System.out.println("熔断方法被调用了");
        Product product = new Product(id, "id" + id + "不合法", "数据库不存在");
        //Product product = new Product(id, "66666", "6666");

        System.out.println(product.getPid().toString());
        System.out.println("product=====>"+product.toString());
        return product;
    }

}
