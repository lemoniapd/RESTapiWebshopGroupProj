package com.example.restapiwebshopgroupproj.ViewControllers;

import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductViewController {
    private final OrderRepository orderRepo;
    private final ProductRepository productRepo;

    ProductViewController(ProductRepository productRepo, OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
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
        return "add-product";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        boolean foundProduct = orderRepo.findAll()
                .stream()
                .anyMatch(order -> order.getProducts().stream().anyMatch(product -> product.getId() == id));

        if (foundProduct) {
            model.addAttribute("message",
                    "Product is present in active orders and can not be deleted.");
            return "unsuccessful";
        } else {
            productRepo.deleteById(id);
            return getAllProducts(model);
        }
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam Optional<String> name,
                             @RequestParam Optional<Double> price,
                             Model model) {
        if (name.isPresent() && price.isPresent()) {
            productRepo.save(new Product(price.get(), name.get()));
            return getAllProducts(model);
        } else {
            model.addAttribute("message",
                    "Product could not be added, please try again with correct values.");
            return "unsuccessful";
        }
    }
}



