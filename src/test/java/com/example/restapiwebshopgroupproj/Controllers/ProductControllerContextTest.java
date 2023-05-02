package com.example.restapiwebshopgroupproj.Controllers;

import com.example.restapiwebshopgroupproj.Models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerContextTest {

    @Value(value = "${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductController productController;

    @Test
    public void contextLoads() {
        assertThat(productController).isNotNull();
    }

    @Test
    public void addProductTest() {
        Product product = new Product(123, "Test");
        String s = this.restTemplate.postForObject("http://localhost:" + port + "/items/add", product, String.class);
        assertThat(s).contains("Test is added to database");
    }
}

