package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Customer;
import com.example.restapiwebshopgroupproj.Repositories.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

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
    public void getAllCustomersTest() throws Exception {
        this.mockMvc.perform(get("/customers")).andExpect(status().isOk()).andExpect(content().json(
                "[{\"id\":1,\"name\": \"Peter\",\"socSecNr\":\"1234567\"}" +
                        ",{\"id\":2,\"name\": \"Lisa\",\"socSecNr\":\"7654321\"}" +
                        ", {\"id\":3,\"name\": \"Lemonia\",\"socSecNr\":\"2345678\"}]"));
    }

    @Test
    public void getCustomerByIdTest() throws Exception {
        this.mockMvc.perform(get("/customers/" + 1L))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        new ObjectMapper()
                                .writeValueAsString(
                                        new Customer(
                                                1L,
                                                "Peter",
                                                "1234567"))));

        this.mockMvc.perform(get("/customers/" + 2L))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        new ObjectMapper()
                                .writeValueAsString(
                                        new Customer(
                                                2L,
                                                "Lisa",
                                                "7654321"))));

        this.mockMvc.perform(get("/customers/" + 3L))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        new ObjectMapper()
                                .writeValueAsString(
                                        new Customer(
                                                3L,
                                                "Lemonia",
                                                "2345678"))));
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        this.mockMvc.perform(get("/customers/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Customer 1 deleted")));

    }

    @Test
    public void addCustomerTest() throws Exception {
        this.mockMvc.perform(post("/customers/add").contentType(MediaType.APPLICATION_JSON).
                        content(new ObjectMapper().writeValueAsString(new Customer("test", "123"))))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer test added"));

    }
}