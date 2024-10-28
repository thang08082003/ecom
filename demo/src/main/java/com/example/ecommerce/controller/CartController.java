package com.example.ecommerce.controller;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Item;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String viewCart(Model model) {
        Cart cart = cartService.getCurrentCart();
        model.addAttribute("cart", cart);
        model.addAttribute("cartTotal", cartService.calculateTotalAmount());
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam int itemId) {
        Item item = itemService.findById(itemId);
        if (item != null) {
            cartService.addItemToCart(item);
        }
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(@RequestParam int itemId) {
        Item item = itemService.findById(itemId);
        if (item != null) {
            cartService.removeItemFromCart(item);
        }
        return "redirect:/cart";
    }
}
