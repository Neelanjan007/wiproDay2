package com.neelanjan.deliveryprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/delivery/status")
    public String getStatus() {
        // Simulated delivery status
        return "Delivery is on the way!";
    }
}
