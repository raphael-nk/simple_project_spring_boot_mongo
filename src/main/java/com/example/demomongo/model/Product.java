package com.example.demomongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;

@Document(collection = "products")
@Data
@AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    private String prodID;

    @NotEmpty(message = "Name field must not be empty")
    private String name;

    private Double price;
    private String description;
}
