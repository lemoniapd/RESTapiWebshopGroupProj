package com.example.restapiwebshopgroupproj.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    protected Long id;
    protected String name;
    protected String socSecNr;

    public Customer(String name, String socSecNr) {
        this.name = name;
        this.socSecNr = socSecNr;
    }

    public Customer(Long id, String name, String socSecNr) {
        this.id = id;
        this.name = name;
        this.socSecNr = socSecNr;
    }
}
