package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;

    public OrderController(OrderRepository orderRepo, CustomerRepository customerRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
    }

    @RequestMapping("/orders")
    public List<Orders> getAllOrders(){
        return orderRepo.findAll();
    }

    @RequestMapping("/orders/{id}")
    public Orders getOrderById(@PathVariable Long id){
        return orderRepo.findById(id).get();
    }

    @RequestMapping("/orders/{customerId}")
    public List<Orders> getOrderByCustomerId(@PathVariable Long customerId){
        Customer currentCustomer = customerRepo.findById(customerId).orElse(null);
    if (currentCustomer!=null){
           return currentCustomer.getOrders();
    }
       //TODO, ändra returtyp vid failure?
    return null;
    }

}
