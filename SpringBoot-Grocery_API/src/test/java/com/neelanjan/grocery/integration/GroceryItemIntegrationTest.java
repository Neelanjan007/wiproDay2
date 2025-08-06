package com.neelanjan.grocery.integration;

import com.neelanjan.grocery.entity.GroceryItem;
import com.neelanjan.grocery.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GroceryItemIntegrationTest {

    @Autowired
    private GroceryItemRepository repo;

    @Test
    void testSaveAndFetch() {
        GroceryItem item = new GroceryItem();
        item.setName("Sugar");
        item.setQuantity(2);
        item.setPrice(20);

        GroceryItem saved = repo.save(item);
        GroceryItem fetched = repo.findById(saved.getId()).orElse(null);

        assertNotNull(fetched);
        assertEquals("Sugar", fetched.getName());
    }
}
