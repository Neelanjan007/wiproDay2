package com.neelanjan.grocery;

import org.springframework.boot.SpringApplication;

import com.neelanjan.grocery.SpringBootGroceryApiApplication;

public class TestSpringBootGroceryApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringBootGroceryApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
