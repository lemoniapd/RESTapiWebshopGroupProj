package com.example.restapiwebshopgroupproj.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @JsonIgnore
    protected Customer customer;

    @OneToMany (fetch = FetchType.EAGER)
    //mappedBy = "orders"
    @JoinColumn
    protected List<Product> products;

    public Orders(Date date, Customer customer, List<Product> products) {
        this.date = date;
        this.customer = customer;
        this.products = products;
    }
    */



    public Orders(Date date, Customer customer, List<Product> products) {
        this.date = date;
        this.customer = customer;
        this.products = products;
    }

}
