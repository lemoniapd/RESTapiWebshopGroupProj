package com.example.restapiwebshopgroupproj.ViewControllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customersView")
public class CustomerViewController {

    private final CustomerRepository customerRepo;
    private final OrderRepository orderRepo;

    public CustomerViewController(CustomerRepository customerRepo, OrderRepository orderRepo) {
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    @RequestMapping("/all")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerRepo.findAll();
        model.addAttribute("title", "All customers");
        model.addAttribute("name", "Customer information");
        model.addAttribute("customers", customers);
        return "show-all-customers";
    }

    @RequestMapping("/add")
    public String addByForm() {
        return "add-customer";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, Model model) {
        boolean foundCustomer = orderRepo.findAll()
                .stream()
                .anyMatch(order -> order.getCustomer().getId() == id);
        if (foundCustomer) {
            model.addAttribute("message", "Customer has active orders, can not be deleted.");
            return "unsuccessful";
        } else {
            customerRepo.deleteById(id);
            return getAllCustomers(model);
        }
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam String name,
                              @RequestParam String socSecNum,
                              Model model) {
        if (!socSecNum.isEmpty() && !name.isEmpty()) {
            customerRepo.save(new Customer(name, socSecNum));
            return getAllCustomers(model);
        } else {
            model.addAttribute("message", "Customer could not be added, please try again with correct values.");
            return "unsuccessful";
        }
    }
}



