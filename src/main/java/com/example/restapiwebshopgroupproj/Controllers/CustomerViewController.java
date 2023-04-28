package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class CustomerViewController {

    private final CustomerRepository customerRepo;

    public CustomerViewController(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @RequestMapping("/all")
    public String getAllProducts(Model model) {
        List<Product> products = productRepo.findAll();
        model.addAttribute("title", "All products");
        model.addAttribute("name", "Product information");
        model.addAttribute("products", products);
        return "show-all-products";
    }

    @RequestMapping("/add")
    public String addByForm() {
        return "add-customer";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, Model model){
        productRepo.deleteById(id);
        return getAllProducts(model);
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam String name,
                             @RequestParam String socSecNum,
                             Model model) {
        if (name.isPresent() && price.isPresent()) {
            productRepo.save(new Product(price.get(), name.get()));
            return getAllProducts(model);
        } else {
            model.addAttribute("message", "Customer could not be added, please try again with correct values.");
            return "unsuccessful";
        }
    }
}



