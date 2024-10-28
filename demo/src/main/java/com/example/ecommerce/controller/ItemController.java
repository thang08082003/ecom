package com.example.ecommerce.controller;

import com.example.ecommerce.model.Item;
import com.example.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/search")
    public String searchItems(@RequestParam(value = "name", required = false) String name, Model model) {
        List<Item> items = itemService.searchItems(name);
        model.addAttribute("items", items);
        model.addAttribute("searchName", name);
        return "search"; // Trả về tên của template
    }
}
