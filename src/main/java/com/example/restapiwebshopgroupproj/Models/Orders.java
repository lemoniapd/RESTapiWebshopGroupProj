package com.example.restapiwebshopgroupproj.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Orders {

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

    public Orders(Customer customer, List<Product> products){
        this.customer = customer;
        this.products = products;
    }
}
