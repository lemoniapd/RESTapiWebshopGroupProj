package com.example.restapiwebshopgroupproj.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue
    protected Long id;
    protected Date date;

    @ManyToOne
    @JoinColumn
    protected Customer customer;

    @OneToMany (mappedBy = "orders", cascade = CascadeType.ALL)
    protected List<Product> products;

    public Orders(Date date, Customer customer, List<Product> products) {
        this.date = date;
        this.customer = customer;
        this.products = products;
    }
}
