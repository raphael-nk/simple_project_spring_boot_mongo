package com.example.demomongo.controller;

import com.example.demomongo.model.Product;
import com.example.demomongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAllProducts();
    }

    @PostMapping
    public Product add(@Valid @RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable String id, @Valid @RequestBody Product  product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
