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
    void getAllOrdersTest() throws Exception {
        List<Orders> ordersToCompare = Arrays.asList(o1, o2, o3);
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(ordersToCompare)));
    }

    @Test
    void getOrderByIdTest() throws Exception {
        this.mockMvc.perform(get("/orders/orderById/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        new ObjectMapper()
                                .writeValueAsString(o1)));
    }

    @Test
        //TODO, fråga Sigrun: Unparsable JSON string: org.json.JSONException: Unparsable JSON string:
    void getOrderByCustomerIdTest() throws Exception {
       this.mockMvc.perform(get("/orders/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(c1.getOrders())));
    }

    //order id , orderdatum, produktlista(produktid, produktnamn,pris)
    /*


    "[{\"id\": 1,\"date\": null,\"products\": [{\"id\" :1,\"price\": 10.9,\"name\": \"Sytråd röd\"}]}, " +
                                "{\"id\": 2, \"date\": null,\"products\": [{\"id\": 1,\"price\": 10.9,\"name\": \"Sytråd röd\"}]}, " +
                                "{\"id\": 3,\"date\": null,\"products\": [{\"id\": 1,\"price\": 10.9,\"name\": \"Sytråd röd\"}]}]"

     //List<Orders> ordersToCompare = new List<Orders>;
     Order o1 = new Orders(1L, List.of(p1));
     Order o2 = new Orders(2L, List.of(p1));
     Order o3 = new Orders(3L, List.of(p1));
     ordersToCompare.add(o1);
     ordersToCompare.add(o2);
     ordersToCompare.add(o);

     Tobi
     Customer currentCustomer = customerRepoTest.findById(1L).orElse(null);
        this.mockMvc.perform(get("/orders/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper()
                        currentCustomer.getOrders()));

       this.mockMvc.perform(get("/orders/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(ordersToCompare)));

     Customer currentCustomer = customerRepo.findById(1L).orElse(null);
     this.mockMvc.perform(get("/orders/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(currentCustomer.getOrders())));


        this.mockMvc.perform(get("/orders"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\": 1,\"date\": null,\"customer\": {\"id\": 1, \"name\": \"Peter\", \"socSecNr\": \"1234567\",\"orders\": null},\"products\": [{\"id\": 1,\"price\": 10.9,\"name\": \"Sytråd röd\"}]}"
                + "{\"id\": 2,\"date\": null,\"customer\": {\"id\": 1,\"name\": \"Peter\",\"socSecNr\": \"1234567\",\"orders\": null},\"products\": [{\"id\": 1,\"price\": 10.9,\"name\": \"Sytråd röd\"}]}"
                + "{\"id\": 3,\"date\": null,\"customer\": {\"id\": 1,\"name\": \"Peter\",\"socSecNr\": \"1234567\",\"orders\": null"},\"products\": [{\"id\": 1,\"price\": 10.9,\"name\": \"Sytråd röd\"}]}]"));
    }

     */
}