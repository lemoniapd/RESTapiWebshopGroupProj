package com.example.restapiwebshopgroupproj.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    protected Long id;
    protected Date date;

    @ManyToOne
    @JoinColumn
    protected Customer customer;

    @OneToMany (mappedBy = "product.id")
    protected List<Product> products;

    public Order(Date date, Customer customer, List<Product> products) {
        this.date = date;
        this.customer = customer;
        this.products = products;
    }
}
