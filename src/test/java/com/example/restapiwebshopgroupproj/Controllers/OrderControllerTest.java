package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerRepository customerRepo;

    /*
    @BeforeEach
    public void init() {
        Customer c1 = new Customer(1L, "Peter", "1234567");
        Product p1 = new Product(1L, 10.9, "Sytråd röd");

        Orders o1 = new Orders(1L, new Date(), c1, List.of(p1));
        Orders o2 = new Orders(1L, new Date(), c1, List.of(p1));
        Orders o3 = new Orders(1L, new Date(), c1, List.of(p1));
        when(customerRepo.findById(1L)).thenReturn(Optional.of(c1));
        when(customerRepo.findById(2L)).thenReturn(Optional.of(c2));
        when(customerRepo.findById(3L)).thenReturn(Optional.of(c3));
        when(customerRepo.findAll()).thenReturn(Arrays.asList(c1, c2, c3));

    }

     */

    @Test
    void getAllOrders() {
    }

    @Test
    void getOrderById() {
    }

    @Test
    void getOrderByCustomerId() {
    }
}