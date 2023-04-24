package com.example.restapiwebshopgroupproj.Repositories;

import com.example.restapiwebshopgroupproj.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
