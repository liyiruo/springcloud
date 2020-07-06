package com.liyiruo.springcloud.service;

import com.liyiruo.springcloud.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liyiruo
 */
@Component
public class ProductClientServiceFallBack implements ProductClientService {
    @Override
    public Product get(Long id) {
        return new Product(id,id+"=>不合法","");
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public boolean add(Product product) {
        return false;
    }
}
