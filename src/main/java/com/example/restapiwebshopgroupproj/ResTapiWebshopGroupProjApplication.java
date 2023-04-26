package com.example.restapiwebshopgroupproj;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ResTapiWebshopGroupProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResTapiWebshopGroupProjApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository customerRepo, ProductRepository productRepository, OrderRepository orderRepository) {
        return (args) -> {

            Customer c1 = new Customer("Lisa", "19930311");
            Customer c2 = new Customer("Lemonia", "19980515");
            Customer c3 = new Customer("Tobias", "19980524");
            Customer c4 = new Customer("Peter", "19890714");

            customerRepo.save(c1);
            customerRepo.save(c2);
            customerRepo.save(c3);
            customerRepo.save(c4);

            Product p1 = new Product(321, "Garnnystan");
            Product p2 = new Product(119, "Garnstickor");
            Product p3 = new Product(21.5, "Virknål 3 mm");
            Product p4 = new Product(5.99, "Sytråd svart");
            Product p5 = new Product(19.9, "Synål 10-p");
            Product p6 = new Product(9999, "Symaskin Ultra fusion x2000");

            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);
            productRepository.save(p4);
            productRepository.save(p5);
            productRepository.save(p6);

            List<Product> productsList = new ArrayList<>();
            productsList.add(p1);
            Orders o1 = new Orders(new Date(), c1, productsList);
            orderRepository.save(o1);

        };
    }


}
