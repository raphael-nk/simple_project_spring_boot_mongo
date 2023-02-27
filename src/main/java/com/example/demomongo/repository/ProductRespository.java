package com.example.demomongo.repository;

import com.example.demomongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRespository extends MongoRepository<Product, String> {
    Product findByName(String name);
    Product findByProdID(String id);
}
