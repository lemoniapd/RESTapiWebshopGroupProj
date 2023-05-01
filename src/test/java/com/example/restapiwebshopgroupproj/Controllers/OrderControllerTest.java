package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderRepository orderRepository;

    @BeforeEach
    public void init() {
        Customer c1 = new Customer(1L, "Peter", "1234567");
        Product p1 = new Product(1L, 10.9, "Sytråd röd");
        Orders o1 = new Orders(1L, new Date(2023 - 05 - 01), c1, List.of(p1));
        Orders o2 = new Orders(2L, new Date(2023 - 05 - 01), c1, List.of(p1));
        Orders o3 = new Orders(3L, new Date(2023 - 05 - 01), c1, List.of(p1));
        when(orderRepository.findById(1L)).thenReturn(Optional.of(o1));
        when(orderRepository.findById(2L)).thenReturn(Optional.of(o2));
        when(orderRepository.findById(3L)).thenReturn(Optional.of(o3));
        when(orderRepository.findAll()).thenReturn(Arrays.asList(o1, o2, o3));
    }

    @Test
    void getAllOrders() throws Exception {
        Customer c1 = new Customer(1L, "Peter", "1234567");
        Product p1 = new Product(1L, 10.9, "Sytråd röd");
        Orders o1 = new Orders(1L, new Date(2023 - 05 - 01), c1, List.of(p1));
        Orders o2 = new Orders(2L, new Date(2023 - 05 - 01), c1, List.of(p1));
        Orders o3 = new Orders(3L, new Date(2023 - 05 - 01), c1, List.of(p1));
        List<Orders> ordersToCompare = Arrays.asList(o1, o2, o3);
        this.mockMvc.perform(get("/orders/"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        new ObjectMapper()
                                .writeValueAsString(
                                        List.of(new Orders(1L, new Date(2023 - 05 - 01),
                                                new Customer(1L, "Peter","1234567"),
                                                List.of(new Product(1L,10.9, "Sytråd röd"))),
                                                new Orders(2L,new Date(2023-05-01),

                                                        new Customer(1L, "Peter","1234567"),
                                                        List.of(new Product(1L,10.9, "Sytråd röd"))),

                                        new Orders(3L,new Date(2023-05-01),
                                                new Customer(1L, "Peter","1234567"),
                                                List.of(new Product(1L,10.9, "Sytråd röd")))))));

    }

    @Test
    void getOrderById() throws Exception {
        this.mockMvc.perform(get("/orders/orderById/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        new ObjectMapper()
                                .writeValueAsString(new Orders(
                                        new Date(2023 - 05 - 01),
                                        new Customer(1L, "Peter", "1234567"),
                                        List.of(new Product(1L,10.9, "Sytråd röd"))))));
    }

    @Test
    void getOrderByCustomerId() throws Exception {
        this.mockMvc.perform(get("/orders/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(new Orders(
                        new Date(2023 - 05 - 01),
                        new Customer(1L, "Peter", "1234567"),
                        List.of(new Product(1L, 10.9, "Sytråd röd"))
                ))));
        this.mockMvc.perform(get("/orders/" + 2L))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(new Orders(
                        new Date(2023 - 05 - 01),
                        new Customer(1L, "Peter", "1234567"),
                        List.of(new Product(1L, 10.9, "Sytråd röd"))
                ))));
        this.mockMvc.perform(get("/orders/" + 3L))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(new Orders(
                        new Date(2023 - 05 - 01),
                        new Customer(1L, "Peter", "1234567"),
                        List.of(new Product(1L, 10.9, "Sytråd röd"))
                ))));
    }
}