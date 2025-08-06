package com.neelanjan.grocery.service;

import com.neelanjan.grocery.entity.GroceryItem;
import java.util.List;

public interface GroceryItemService {
    GroceryItem addItem(GroceryItem item);
    List<GroceryItem> getAllItems();
    GroceryItem getItemById(Long id);
    GroceryItem updateItem(Long id, GroceryItem item);
    void deleteItem(Long id);
}
