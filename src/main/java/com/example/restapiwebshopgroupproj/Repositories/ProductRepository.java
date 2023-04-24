package com.example.restapiwebshopgroupproj.Repositories;

import com.example.restapiwebshopgroupproj.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
