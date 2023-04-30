package com.example.restapiwebshopgroupproj.Controllers;


import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @PostMapping("/items/add")
    public String addProduct(@RequestBody Product product) {
        try {
            productRepo.save(product);
            return product.getName() + " is added to database";
        } catch (Exception e){
            return "Something went wrong when trying to add product!";
        }
    }

    @PostMapping("/items/buy")
    public String buyProduct(@RequestParam Long productId, @RequestParam Long customerId) {
        List<Product> products = new ArrayList<>();
        Product product = productRepo.findById(productId).orElse(null);
        Customer customer = customerRepo.findById(customerId).orElse(null);

        if (product != null && customer != null) {
            products.add(product);
            Orders order = new Orders(new Date(), customer, products);
            orderRepo.save(order);
            return "Order number " + order.getId() + " is added";
        }
        return "Product ID or customer ID does not exist.";
    }
}
