package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return repo.findById(id).get();
    }

    @PostMapping("/customers")
    public String addCustomer(@RequestBody Customer customer) {
        repo.save(customer);
        return "Customer " + customer.getName() + " added";
    }





}
