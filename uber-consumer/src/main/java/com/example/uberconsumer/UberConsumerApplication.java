package com.example.uberconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com"})
public class UberConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UberConsumerApplication.class, args);
    }
}
