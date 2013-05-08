
package com.credera.talk.thymeleaf.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.credera.talk.thymeleaf.domain.Category;
import com.credera.talk.thymeleaf.domain.Product;
import com.credera.talk.thymeleaf.domain.User;
import com.credera.talk.thymeleaf.service.CatalogService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

public abstract class DemoController {

    @Resource
    protected CatalogService catalogService;

    @ModelAttribute("user")
    public User getUser() {
        return new User("Justin", "Munn");
    }

    @ModelAttribute("products")
    public List<Product> getProducts() {
        return catalogService.getAllProducts();
    }

    @ModelAttribute("productMap")
    public Map<Long, Product> getProductMap() {
        return catalogService.getProductsMap();
    }

    @ModelAttribute("categoryProductMap")
    public Map<Long, List<Product>> getCategoryProductMap() {
        return catalogService.getCategoryProductsMap();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return catalogService.getAllCategories();
    }
}
