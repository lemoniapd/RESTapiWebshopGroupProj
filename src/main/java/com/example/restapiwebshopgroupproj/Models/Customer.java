package com.example.restapiwebshopgroupproj.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    protected String socSecNr;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    protected List<Orders> orderList = new ArrayList<>();

    public Customer(String name, String socSecNr) {
        this.name = name;
        this.socSecNr = socSecNr;
    }
}
