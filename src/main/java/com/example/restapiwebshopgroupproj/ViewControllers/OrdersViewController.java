package com.example.restapiwebshopgroupproj.ViewControllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ordersView")
public class OrdersViewController {

    private final OrderRepository ordersRepo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public OrdersViewController(OrderRepository ordersRepo, CustomerRepository customerRepo, ProductRepository productRepo) {
        this.ordersRepo = ordersRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    @Transactional
    @RequestMapping("/all")
    public String getAllOrders(Model model) {
        List<Orders> ordersList = ordersRepo.findAll();
        model.addAttribute("title", "All orders");
        model.addAttribute("name", "Order information");
        model.addAttribute("ordersList", ordersList);
        return "show-all-orders";
    }

    @RequestMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id, Model model) {
        ordersRepo.deleteById(id);
        return getAllOrders(model);
    }

    @RequestMapping("/add")
    public String addByForm() {
        return "add-order";
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam Long customerID,
                           @RequestParam Long productID,
                           Model model) {

        Customer customer = customerRepo.findById(customerID).orElse(null);
        List<Product> products = new ArrayList<>();
        Product product = productRepo.findById(productID).orElse(null);

        if (customer != null && product != null) {
            products.add(product);
            ordersRepo.save(new Orders(new Date(), customer, products));
            return getAllOrders(model);
        } else if (customer == null) {
            model.addAttribute("message", "Order could not be added, please try again with correct customer ID.");
            return "unsuccessful";
        } else if (product == null) {
            model.addAttribute("message","Order could not be added, please try again with correct product ID.");
            return "unsuccessful";
        } else {
            model.addAttribute("message","Order could not be added, please try again with correct values.");
            return "unsuccessful";
        }
    }
}