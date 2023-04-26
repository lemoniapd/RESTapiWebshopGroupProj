package com.example.restapiwebshopgroupproj.Repositories;

import com.example.restapiwebshopgroupproj.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
