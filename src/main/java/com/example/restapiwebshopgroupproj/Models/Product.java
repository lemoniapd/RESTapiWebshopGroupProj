package com.example.restapiwebshopgroupproj.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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