package com.neelanjan.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neelanjan.grocery.entity.GroceryItem;
import com.neelanjan.grocery.service.GroceryItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/grocery")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    
    public GroceryItemController(GroceryItemService service) {
		
	}


	@PostMapping("/addItem")
    public ResponseEntity<GroceryItem> addItem(@Valid @RequestBody GroceryItem item) {
        GroceryItem saved = groceryItemService.addItem(item);
        return ResponseEntity.ok(saved);
    }


    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(groceryItemService.getAllItems());
    }

   
    @GetMapping("/items/{id}")
    public ResponseEntity<GroceryItem> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(groceryItemService.getItemById(id));
    }

  
    @PutMapping("/items/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @Valid @RequestBody GroceryItem updatedItem) {
        return ResponseEntity.ok(groceryItemService.updateItem(id, updatedItem));
    }

   
    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        groceryItemService.deleteItem(id);
        return ResponseEntity.ok("Item with ID " + id + " deleted successfully.");
    }
}
