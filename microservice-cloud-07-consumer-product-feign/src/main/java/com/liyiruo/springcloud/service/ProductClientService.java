package com.liyiruo.springcloud.service;

import com.liyiruo.springcloud.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author liyiruo
 * //指定调用的服务 MICROSERVICE-PRODUCT
 */
@FeignClient(value = "MICROSERVICE-PRODUCT")
public interface ProductClientService {
    /**
     * 获取一行数据
     * @param id 参数
     * @return Product
     */
    @GetMapping("/product/get/{id}")
    Product get(@PathVariable Long id);

    /**
     * 获取一组数据
     * @return list
     */
    @GetMapping("product/list")
    List<Product> list();

    /**
     * 添加一条数据
     * @param product 一个产品
     * @return 是否成功
     */
    @PostMapping("/product/add")
    boolean add(Product product);

}
