
package com.credera.talk.thymeleaf.service;

import org.springframework.stereotype.Service;

import com.credera.talk.thymeleaf.domain.Money;
import com.credera.talk.thymeleaf.domain.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

@Service("productService")
public class ProductService {

    private long sequence = 0;
    private Map<Long, Product> products = new HashMap<>();

    @PostConstruct
    protected void initProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(createProduct("12345", "Test Widget", "This widget helps testing gizmos", new Money("10.00"), "Widget"));
        productList.add(createProduct("23452", "Multi-Widget", "Like a normal widget, but multi", new Money("100.00"), "Widget"));
        productList.add(createProduct("8238734", "Gizmo", "This is your standard gizmo", new Money("30.50"), "Gizmo"));
        productList.add(createProduct("289720", "Gizmo Mini", "All the fun of a gizmo, but smaller", new Money("17.00"), "Gizmo"));
        productList.add(createProduct("3342752", "iWidget", "A widget that will be recalled to do copyright infringment", new Money("109.00"), "Widget"));
        productList.add(createProduct("65436863", "Super Gizmo", "This is the super version of a normal gizmo", new Money("63"), "Gizmo"));
        productList.add(createProduct("2345262", "Micro Widget", "So micro, it is pretty much useless", new Money("1.25"), "Widget"));
        productList.add(createProduct("2345w4", "Secret Sauce", "We dont know what category this goes in", new Money("15"), "Foo"));

        for (Product product : productList) {
            products.put(product.getId(), product);
        }
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>(products.values());
        Collections.sort(productList, new Comparator<Product>() {

            @Override
            public int compare(Product o1, Product o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return productList;
    }

    public Map<Long, Product> getProductsMap() {
        return products;
    }

    public Map<String, List<Product>> getCategoryProductsMap() {
        Map<String, List<Product>> categoryProductMap = new TreeMap<>();
        for (Product product : getAllProducts()) {
            if (!categoryProductMap.containsKey(product.getCategoryName())) {
                categoryProductMap.put(product.getCategoryName(), new ArrayList<Product>());
            }
            categoryProductMap.get(product.getCategoryName()).add(product);
        }
        return categoryProductMap;
    }

    public void saveProduct(Product product) {
        if (product.getId() != null) {
            products.put(product.getId(), product);
        } else {
            product.setId(getNextId());
        }
        products.put(product.getId(), product);
    }

    private Product createProduct(String sku, String name, String description, Money price, String categoryName) {
        long id = getNextId();
        Product product = new Product();
        product.setSku(sku);
        product.setName(name);
        product.setDescription(description);
        product.setCategoryName(categoryName);
        product.setPrice(price);
        product.setId(id);
        return product;
    }

    private long getNextId() {
        sequence++;
        return sequence;
    }
}
