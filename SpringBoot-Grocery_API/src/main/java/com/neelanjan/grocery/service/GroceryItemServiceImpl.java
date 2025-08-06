package com.neelanjan.grocery.service;

import com.neelanjan.grocery.entity.GroceryItem;
import com.neelanjan.grocery.repository.GroceryItemRepository;
import com.neelanjan.grocery.exception.ResourceNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    @Autowired
    private GroceryItemRepository repo;

    @Override
    public GroceryItem addItem(GroceryItem item) {
        return repo.save(item);
    }

    @Override
    public List<GroceryItem> getAllItems() {
        return repo.findAll();
    }

    @Override
    public GroceryItem getItemById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with ID: " + id));
    }

    @Override
    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        GroceryItem existing = getItemById(id);
        existing.setName(updatedItem.getName());
        existing.setPrice(updatedItem.getPrice());
        existing.setQuantity(updatedItem.getQuantity());
        return repo.save(existing);
    }

    @Override
    public void deleteItem(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Item not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}
