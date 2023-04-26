package com.example.restapiwebshopgroupproj.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    protected Long id;
/*
    @GeneratedValue
    protected Date date;

 */

    @ManyToOne
    @JoinColumn
    protected Customer customer;

    @OneToMany (mappedBy = "orders")
    protected List<Product> products;

    public Order(Customer customer, List<Product> products){
        this.customer = customer;
        this.products = products;
    }
}
