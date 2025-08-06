package com.neelanjan.grocery.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.neelanjan.grocery.entity.GroceryItem;
import com.neelanjan.grocery.service.GroceryItemService;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    private GroceryItemService service;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        service = Mockito.mock(GroceryItemService.class);
        GroceryItemController controller = new GroceryItemController(service);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllItems() throws Exception {
        when(service.getAllItems()).thenReturn(List.of(
            new GroceryItem(1L, "Rice", 10, 20.5)
        ));

        mockMvc.perform(get("/api/items"))
                .andExpect(status().isOk());
    }
}
