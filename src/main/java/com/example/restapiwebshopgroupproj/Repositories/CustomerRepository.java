package com.example.restapiwebshopgroupproj.Repositories;

import com.example.restapiwebshopgroupproj.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
