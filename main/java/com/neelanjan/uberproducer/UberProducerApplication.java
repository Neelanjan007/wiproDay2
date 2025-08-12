package com.neelanjan.uberproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.neelanjan.controller", "com.neelanjan.service"})
@EntityScan(basePackages = "com.neelanjan.entity")
@EnableJpaRepositories(basePackages = "com.neelanjan.repository")
public class UberProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberProducerApplication.class, args);
    }
}