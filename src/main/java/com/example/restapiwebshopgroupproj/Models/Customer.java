package com.example.restapiwebshopgroupproj.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    protected String socSecNr;

    @OneToMany (mappedBy = "order.id")
    protected List<Order> orderList;

    public Customer(String name, String socSecNr, List<Order> orderList) {
        this.name = name;
        this.socSecNr = socSecNr;
        this.orderList = orderList;
    }
}
