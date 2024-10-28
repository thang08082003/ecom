package com.example.ecommerce.repository;

import com.example.ecommerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByNameContainingIgnoreCase(String name);
}
