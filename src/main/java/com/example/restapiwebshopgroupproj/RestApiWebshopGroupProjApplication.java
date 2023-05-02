package com.example.restapiwebshopgroupproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiWebshopGroupProjApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiWebshopGroupProjApplication.class, args);
    }

/*
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

            Orders o1 = new Orders(new Date(),c1,List.of(p1, p2, p3));
            Orders o2 = new Orders(new Date(),c2,List.of(p2));
            Orders o3 = new Orders(new Date(),c3,List.of(p3));

            orderRepository.save(o1);
            orderRepository.save(o2);
            orderRepository.save(o3);

        };
    }

 */



}