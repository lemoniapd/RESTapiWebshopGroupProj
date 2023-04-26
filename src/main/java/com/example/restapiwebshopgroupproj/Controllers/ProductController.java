package com.example.restapiwebshopgroupproj.Controllers;


import com.example.restapiwebshopgroupproj.Models.Order;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;
    private final OrderRepository orderRepo;

    public ProductController(ProductRepository productRepo, CustomerRepository customerRepo, OrderRepository orderRepo) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    @RequestMapping("/items")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @RequestMapping("/items/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @PostMapping("/items")
    public String addProduct(@RequestBody Product product) {
        try {
            productRepo.save(product);
            return product.getName() + " is added to database";
        } catch (Exception e){
            return "Something went wrong when trying to add product!";
        }
    }

    @PostMapping("/items/buy")
    public String addToCart(@RequestParam Long productId, @RequestParam Long customerId){
        Order order = n
    }


}
