package com.example.spring.service;

import com.example.spring.model.Category;
import com.example.spring.model.Product;
import com.example.spring.repositry.CategoryRepositry;
import com.example.spring.repositry.ProductRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbProductService implements ProductService{

    private final CategoryRepositry categoryRepositry;
    private final ProductRepositry productRepositry;

    public DbProductService(CategoryRepositry categoryRepositry, ProductRepositry productRepositry) {
        this.categoryRepositry = categoryRepositry;
        this.productRepositry = productRepositry;
    }

    @Override
    public Product createProduct(Product product) throws Exception {
        Product products = new Product();
        products.setTitle(product.getTitle());

        try {
            Optional<Category> category = categoryRepositry.findByName(product.getCategory().getName());
            if(category == null)
            {
                Category neCat = new Category();
                neCat.setName(product.getCategory().getName());
                Category newRow =categoryRepositry.save(neCat);
                product.setCategory(newRow);
            } else {
                product.setCategory(category.get());
            }
            products = productRepositry.save(product);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Product not found");
        }
        products.setPrice(product.getPrice());
        products.setDescription(product.getDescription());

        return products;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = productRepositry.findAll();
        return  productList;
    }

    @Override
    public Category createCategory(Category category) throws Exception {
        Category categorys = new Category();
        if(category == null)
        {
            throw new Exception("category is null");
        }
        categorys.setName(category.getName());
        categorys.setStock(category.getStock());
        categorys = categoryRepositry.save(categorys);
        return categorys;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryRepositry.findAll();
        return  categoryList;
    }
}
