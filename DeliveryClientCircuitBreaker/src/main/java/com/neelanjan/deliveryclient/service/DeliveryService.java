package com.neelanjan.deliveryclient.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeliveryService {

    private static final String DELIVERY_SERVICE = "deliveryService";

    private final RestTemplate restTemplate;

    public DeliveryService() {
        this.restTemplate = new RestTemplate();
    }

    @CircuitBreaker(name = DELIVERY_SERVICE, fallbackMethod = "fallbackDeliveryStatus")
    public String fetchDeliveryStatus() {
        String externalUrl = "http://localhost:8081/delivery/status";  // This is what we're hitting
        return restTemplate.getForObject(externalUrl, String.class);
    }

    public String fallbackDeliveryStatus(Throwable t) {
        return "Fallback: Unable to retrieve delivery status at this time. Please try again later.";
    }
}
