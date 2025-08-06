package com.neelanjan.grocery.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.neelanjan.grocery.entity.GroceryItem;
import com.neelanjan.grocery.repository.GroceryItemRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepository groceryItemRepository;

    @InjectMocks
    private GroceryItemServiceImpl groceryItemService;

    @Test
    void testAddItem() {
        GroceryItem item = new GroceryItem(null, "Apple", 10, 25.0);
        when(groceryItemRepository.save(any())).thenReturn(item);

        GroceryItem saved = groceryItemService.addItem(item);
        assertEquals("Apple", saved.getName());
    }
}
