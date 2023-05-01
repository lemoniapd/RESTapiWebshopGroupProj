package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepo;
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {

        return customerRepo.findById(id).orElse(null);
    }

    @RequestMapping("customers/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerRepo.deleteById(id);
        return "Customer " + id + " deleted";
    }

    @PostMapping("/customers/add")
    public String addCustomer(@RequestBody Customer customer) {
        try {
            customerRepo.save(customer);
            return "Customer " + customer.getName() + " added";
        } catch (Exception e) {
            return "Something went wrong when trying to add customer!";
        }
    }
}
