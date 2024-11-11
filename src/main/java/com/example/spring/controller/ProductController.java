package com.example.spring.controller;

import com.example.spring.dto.ProductResponseDto;
import com.example.spring.model.Category;
import com.example.spring.model.Product;
import com.example.spring.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws Exception {
        try {
            Product products = productService.createProduct(product);
            return new ResponseEntity<>(products, HttpStatus.CREATED);
        } catch (Exception e){
           throw new Exception("Not created");
        }
    }
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct() throws Exception {
        try {
            List<Product> products = productService.getAllProduct();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e){
            throw new Exception("Not created");
        }
    }

    @PostMapping("/category")
    public ResponseEntity<Category> createCategorys(@RequestBody Category category) throws Exception {
        try {
            Category categorys = productService.createCategory(category);
            return new ResponseEntity<>(categorys, HttpStatus.CREATED);
        } catch (Exception e){
            throw new Exception("Not created");
        }
    }
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() throws Exception {
        try {
            List<Category> categorys = productService.getAllCategory();
            return new ResponseEntity<>(categorys, HttpStatus.OK);
        } catch (Exception e){
            throw new Exception("Not created");
        }
    }
}
