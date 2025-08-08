package com.neelanjan.grocery.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Welcome to the Public Grocery Section!";
    }

    @GetMapping("/items")
    public String itemsEndpoint() {
        return "Here are the grocery items.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/orders")
    public String ordersEndpoint() {
        return "Here are all the grocery orders (Admin only).";
    }
}
