package com.example.restapiwebshopgroupproj.ViewControllers;

import com.example.restapiwebshopgroupproj.Models.Product;
import com.example.restapiwebshopgroupproj.Repositories.ProductRepository;
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
class ProductViewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductRepository productRepo;

    @BeforeEach
    public void init() {
        Product p1 = new Product(1L, 10.9, "Sytråd röd");
        Product p2 = new Product(2L, 499.0, "Billig symaskin");
        Product p3 = new Product(3L, 1200, "Guldtråd");
        when(productRepo.findById(1L)).thenReturn(Optional.of(p1));
        when(productRepo.findById(2L)).thenReturn(Optional.of(p2));
        when(productRepo.findById(3L)).thenReturn(Optional.of(p3));
        when(productRepo.findAll()).thenReturn(Arrays.asList(p1, p2, p3));
    }

    @Test
    void getAllProductsTest() throws Exception {
        this.mockMvc.perform(get("/products/all"))
                .andExpect(status().isOk());
    }

    @Test
    void addByFormTest() throws Exception {
        this.mockMvc.perform(get("/products/add"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCategoryTest() throws Exception {
        this.mockMvc.perform(get("/products/delete/" + 1L))
                .andExpect(status().isOk());
    }

    @Test
    void addProductTest() throws Exception {
        this.mockMvc.perform(post("/products/addProduct"))
                .andExpect(status().isOk());
    }
}