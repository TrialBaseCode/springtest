package com.example.spring.service;

import com.example.spring.model.Category;
import com.example.spring.model.Product;


import java.util.List;


public interface ProductService {

    Product createProduct(Product product) throws Exception;
    List<Product> getAllProduct();
    Category createCategory(Category category) throws Exception ;
    List<Category> getAllCategory();
}
