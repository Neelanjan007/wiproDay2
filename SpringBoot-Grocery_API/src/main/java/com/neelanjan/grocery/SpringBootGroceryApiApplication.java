package com.neelanjan.grocery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages ="com.neelanjan.grocery")
@EnableJpaRepositories(basePackages ="com.neelanjan.grocery.repository")
@EntityScan(basePackages ="com.neelanjan.grocery.entity")
public class SpringBootGroceryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootGroceryApiApplication.class, args);
    }
}
