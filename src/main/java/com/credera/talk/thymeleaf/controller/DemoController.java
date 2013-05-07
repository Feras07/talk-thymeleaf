
package com.credera.talk.thymeleaf.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.credera.talk.thymeleaf.domain.Product;
import com.credera.talk.thymeleaf.domain.User;
import com.credera.talk.thymeleaf.service.ProductService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

public abstract class DemoController {

    @Resource
    protected ProductService productService;

    @ModelAttribute("user")
    public User getUser() {
        return new User("Justin", "Munn");
    }

    @ModelAttribute("products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @ModelAttribute("productMap")
    public Map<Long, Product> getProductMap() {
        return productService.getProductsMap();
    }

    @ModelAttribute("categoryProductMap")
    public Map<String, List<Product>> getCategoryProductMap() {
        return productService.getCategoryProductsMap();
    }
}
