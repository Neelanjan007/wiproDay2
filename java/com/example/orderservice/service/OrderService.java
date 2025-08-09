package com.example.orderservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String placeOrder() {
       
        String paymentResponse = restTemplate.getForObject(
                "http://localhost:9999/payment", String.class);

        return "Order placed successfully! -> " + paymentResponse;
    }
}
