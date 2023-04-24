package com.example.restapiwebshopgroupproj.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    protected Long id;
    protected double price;
    protected String name;

    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }
}
