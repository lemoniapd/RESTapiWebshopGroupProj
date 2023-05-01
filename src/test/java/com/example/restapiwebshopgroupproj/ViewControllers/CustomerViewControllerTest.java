package com.example.restapiwebshopgroupproj.ViewControllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerViewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerRepository customerRepo;

    @BeforeEach
    public void init() {
        Customer c1 = new Customer(1L, "Peter", "1234567");
        Customer c2 = new Customer(2L, "Lisa", "7654321");
        Customer c3 = new Customer(3L, "Lemonia", "2345678");
        when(customerRepo.findById(1L)).thenReturn(Optional.of(c1));
        when(customerRepo.findById(2L)).thenReturn(Optional.of(c2));
        when(customerRepo.findById(3L)).thenReturn(Optional.of(c3));
        when(customerRepo.findAll()).thenReturn(Arrays.asList(c1, c2, c3));
    }

    @Test
    void getAllCustomersTest() throws Exception {
        this.mockMvc.perform(get("/customersView/all"))
                .andExpect(status().isOk());
    }

    @Test
    void addByFormTest() throws Exception {
        this.mockMvc.perform(get("/customersView/add"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCustomerTest() throws Exception {
        this.mockMvc.perform(get("/customersView/delete/" + 1L))
                .andExpect(status().isOk());
    }

    @Test
    void addCustomerTest() throws Exception {
        this.mockMvc.perform(post("/customersView/addCustomer?name=LisaFisa&socSecNum=000"))
                .andExpect(status().isOk());
    }
}