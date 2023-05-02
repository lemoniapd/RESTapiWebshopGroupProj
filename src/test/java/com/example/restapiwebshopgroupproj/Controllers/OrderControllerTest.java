package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
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
    Customer c1;
    Orders o1;
    Orders o2;
    Orders o3;
    Product p1;


    @MockBean
    OrderRepository orderRepoTest;
    @MockBean
    CustomerRepository customerRepoTest;

    @BeforeEach
    public void init() {
        c1 = new Customer(1L, "Peter", "1234567");
        when(customerRepoTest.findById(1L)).thenReturn(Optional.of(c1));

        p1 = new Product(1L, 10.9, "Sytråd röd");
        o1 = new Orders(1L, c1, List.of(p1));
        o2 = new Orders(2L, c1, List.of(p1));
        o3 = new Orders(3L, c1, List.of(p1));

        when(orderRepoTest.findById(1L)).thenReturn(Optional.of(o1));
        when(orderRepoTest.findById(2L)).thenReturn(Optional.of(o2));
        when(orderRepoTest.findById(3L)).thenReturn(Optional.of(o3));
        when(orderRepoTest.findAll()).thenReturn(Arrays.asList(o1, o2, o3));
    }

    @Test
    public void getAllOrdersTest() throws Exception {
        List<Orders> ordersToCompare = Arrays.asList(o1, o2, o3);
        mockMvc.perform(get("/orders/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(ordersToCompare)));
    }

    @Test
    public void getOrderByIdTest() throws Exception {
        this.mockMvc.perform(get("/orders/orderById/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        new ObjectMapper()
                                .writeValueAsString(o1)));
    }

    @Test
    public void getOrderByCustomerIdTest() throws Exception {
        List<Orders> ordersToCompare = Arrays.asList(o1, o2, o3);
        this.mockMvc.perform(get("/orders/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(ordersToCompare)));
    }
}