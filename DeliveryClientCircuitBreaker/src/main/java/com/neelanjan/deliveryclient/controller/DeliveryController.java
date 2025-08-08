package com.neelanjan.deliveryclient.controller;

import com.neelanjan.deliveryclient.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/status")
    public String getStatus() {
        return deliveryService.fetchDeliveryStatus();
    }
}
