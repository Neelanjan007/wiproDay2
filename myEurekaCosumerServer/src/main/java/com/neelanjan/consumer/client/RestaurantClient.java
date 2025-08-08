package com.neelanjan.consumer.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Food;
import com.entity.Restaurant;

@RestController
@RequestMapping("/consumer")
public class RestaurantClient {

    @Autowired
    private RestaurantApiClient restaurantApiClient;

    @GetMapping("/restaurants")
    public List<Restaurant> fetchRestaurants() {
        return restaurantApiClient.getAllRestaurants();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant fetchRestaurantById(@PathVariable Long id) {
        return restaurantApiClient.getRestaurantById(id);
    }

    @GetMapping("/foods")
    public List<Food> fetchFoods() {
        return restaurantApiClient.getAllFoodItems();
    }
}
