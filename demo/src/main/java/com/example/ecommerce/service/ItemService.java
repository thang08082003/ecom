package com.example.ecommerce.service;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> searchItems(String name) {
        if (name == null || name.isEmpty()) {
            return Collections.emptyList(); // Trả về danh sách rỗng nếu không có tìm kiếm
        }
        return itemRepository.findByNameContainingIgnoreCase(name); // Tìm sản phẩm theo tên
    }

    public Item findById(int itemId) {
        return itemRepository.findById(itemId).orElse(null); // Tìm sản phẩm theo ID
    }
}
