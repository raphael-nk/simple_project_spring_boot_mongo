package com.example.demomongo.service;

import com.example.demomongo.model.Product;
import com.example.demomongo.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRespository productRespository;

    // CRUD

    public Product addProduct(Product product){
        return productRespository.save(product);
    }

    public List<Product> findAllProducts(){
        return productRespository.findAll();
    }

    public Product getProductById(String productID){

        return productRespository.findByProdID(productID);
    }

    public Product updateProduct(String productID, Product product){
        Product existingProduct = productRespository.findByProdID(productID);
        if(Objects.isNull(existingProduct)) return null;

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());

        return productRespository.save(existingProduct);
    }

    public String deleteProduct(String productID){
        try{
            Product prod = productRespository.findByProdID(productID);
            if(prod != null) productRespository.deleteById(productID);

            return "The product is deleted";
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
