package com.neelanjan.consumer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.entity.Food;
import com.entity.Restaurant;

@FeignClient(name ="Restaurant-api")
public interface RestaurantApiClient {

    @GetMapping("/api/restaurants")
    List<Restaurant> getAllRestaurants();

    @GetMapping("/api/restaurants/{id}")
    Restaurant getRestaurantById(@PathVariable("id") Long id);

    @PostMapping("/api/restaurants")
    Restaurant createRestaurant(@RequestBody Restaurant restaurant);

    @DeleteMapping("/api/restaurants/{id}")
    void deleteRestaurant(@PathVariable("id") Long id);

    @PostMapping("/api/restaurants/{id}/foods")
    Food addFood(@PathVariable("id") Long id, @RequestBody Food food);

    @DeleteMapping("/api/restaurants/foods/{foodId}")
    void deleteFood(@PathVariable("foodId") Long foodId);

    @GetMapping("/api/restaurant/food/all")
    List<Food> getAllFoodItems();
}
