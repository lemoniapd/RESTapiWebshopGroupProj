package com.example.restapiwebshopgroupproj.Controllers;


import com.example.restapiwebshopgroupproj.Models.Order;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepo;
    private final CustomerRepository customerRepo;


    public ProductController(ProductRepository productRepo, CustomerRepository customerRepo) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }

    @RequestMapping("/items")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @RequestMapping("/items/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepo.findById(id).get();
    }

    @PostMapping("/items")
    public String addItem(@RequestBody Product product){
        productRepo.save(product);
        return product.getName() + " is added to database";
    }

    @PostMapping("/items/buy")
    public String addToCart(@RequestParam Long productId, @RequestParam Long customerId){
        Order order = n
    }


}
