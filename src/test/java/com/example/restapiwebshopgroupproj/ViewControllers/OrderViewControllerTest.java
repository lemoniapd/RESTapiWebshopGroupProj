package com.example.restapiwebshopgroupproj.ViewControllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderViewControllerTest {

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