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

    @Test
    void getAllCustomers() {
    }

    @Test
    void addByForm() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void addCustomer() {
    }
}