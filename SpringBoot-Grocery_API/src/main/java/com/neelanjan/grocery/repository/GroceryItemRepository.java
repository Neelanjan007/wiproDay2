package com.neelanjan.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neelanjan.grocery.entity.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {}
