package com.example.restapiwebshopgroupproj.ViewControllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Models.Orders;
import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.OrderRepository;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrdersViewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderRepository orderRepo;

    @BeforeEach
    public void init() {
        Customer c1 = new Customer(1L, "Peter", "1234567");

        Product p1 = new Product(1L, 10.9, "Sytråd röd");
        Orders o1 = new Orders(1L, new Date(), c1, List.of(p1));
        Orders o2 = new Orders(2L, new Date(), c1, List.of(p1));
        Orders o3 = new Orders(3L, new Date(), c1, List.of(p1));

        when(orderRepo.findById(1L)).thenReturn(Optional.of(o1));
        when(orderRepo.findById(2L)).thenReturn(Optional.of(o2));
        when(orderRepo.findById(3L)).thenReturn(Optional.of(o3));
        when(orderRepo.findAll()).thenReturn(Arrays.asList(o1, o2, o3));
    }
    @Test
    void getAllOrdersTest() throws Exception {
        this.mockMvc.perform(get("/ordersView/all"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteOrderTest() throws Exception{
        this.mockMvc.perform(get("/ordersView/delete/"+1L))
                .andExpect(status().isOk());
    }

    @Test
    void addByFormTest() throws Exception{
        this.mockMvc.perform(get("/ordersView/add"))
                .andExpect(status().isOk());
    }

    @Test
    void addOrderTest() throws Exception {
        this.mockMvc.perform(post("/ordersView/addOrder?customerID=1&productID=1"))
                .andExpect(status().isOk());
    }
}