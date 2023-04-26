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
    
    @DateTimeFormat
    protected Date date;

    @ManyToOne
    @JoinColumn
    protected Customer customer;

    @OneToMany (mappedBy = "product.id")
    protected List<Product> products;

    public Order(Customer customer, List<Product> products){
        this.customer = customer;
        this.products = products;
    }
}
