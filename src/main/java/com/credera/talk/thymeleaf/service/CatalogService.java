
package com.credera.talk.thymeleaf.service;

import org.springframework.stereotype.Service;

import com.credera.talk.thymeleaf.domain.Category;
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
public class CatalogService {

    private long productSequence = 0;
    private long categorySequence = 0;
    private Map<Long, Product> products = new HashMap<>();
    private Map<Long, Category> categories = new HashMap<>();

    @PostConstruct
    public CatalogService initProducts() {
        Category widgetCategory = new Category(getNextCategoryId(), "Widget", "Widgets do things");
        Category gizmoCategory = new Category(getNextCategoryId(), "Gizmo", "Gizmos are are used to build things");
        Category fooCategory = new Category(getNextCategoryId(), "Foo", "We don't know what these do");

        categories.put(widgetCategory.getId(), widgetCategory);
        categories.put(gizmoCategory.getId(), gizmoCategory);
        categories.put(fooCategory.getId(), fooCategory);

        List<Product> productList = new ArrayList<>();
        productList.add(createProduct("12345", "Test Widget", "This widget helps testing gizmos", new Money("10.00"), widgetCategory));
        productList.add(createProduct("23452", "Multi-Widget", "Like a normal widget, but multi", new Money("100.00"), widgetCategory));
        productList.add(createProduct("8238734", "Gizmo", "This is your standard gizmo", new Money("30.50"), gizmoCategory));
        productList.add(createProduct("289720", "Gizmo Mini", "All the fun of a gizmo, but smaller", new Money("17.00"), gizmoCategory));
        productList.add(createProduct("3342752", "iWidget", "A widget that will be recalled to do copyright infringment", new Money("109.00"), widgetCategory));
        productList.add(createProduct("65436863", "Super Gizmo", "This is the super version of a normal gizmo", new Money("63", "EUR"), gizmoCategory));
        productList.add(createProduct("2345262", "Micro Widget", "So micro, it is pretty much useless", new Money("1.25"), widgetCategory));
        productList.add(createProduct("2345w4", "Secret Sauce", "We dont know what category this goes in", new Money("1500", "MXN"), fooCategory));

        for (Product product : productList) {
            products.put(product.getId(), product);
        }
        return this;
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

    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>(categories.values());
        Collections.sort(categoryList, new Comparator<Category>() {

            @Override
            public int compare(Category o1, Category o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return categoryList;

    }

    public Map<Long, Product> getProductsMap() {
        return products;
    }

    public Map<Long, Category> getCategoriesMap() {
        return categories;
    }

    public Map<Long, List<Product>> getCategoryProductsMap() {
        Map<Long, List<Product>> categoryProductMap = new TreeMap<>();
        for (Product product : getAllProducts()) {
            if (!categoryProductMap.containsKey(product.getCategory().getId())) {
                categoryProductMap.put(product.getCategory().getId(), new ArrayList<Product>());
            }
            categoryProductMap.get(product.getCategory().getId()).add(product);
        }
        return categoryProductMap;
    }

    public void saveProduct(Product product) {
        if (product.getId() != null) {
            products.put(product.getId(), product);
        } else {
            product.setId(getNextProductId());
        }
        products.put(product.getId(), product);
    }

    public void saveCategory(Category category) {
        if (category.getId() != null) {
            categories.put(category.getId(), category);
        } else {
            category.setId(getNextCategoryId());
        }
        categories.put(category.getId(), category);
    }

    private Product createProduct(String sku, String name, String description, Money price, Category category) {
        long id = getNextProductId();
        Product product = new Product();
        product.setSku(sku);
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);
        product.setId(id);
        return product;
    }

    private long getNextProductId() {
        productSequence++;
        return productSequence;
    }

    private long getNextCategoryId() {
        categorySequence++;
        return categorySequence;
    }
}
