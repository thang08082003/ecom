package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Item;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Cart getCurrentCart() {
        return cartRepository.findById(1).orElseGet(() -> {
            Cart newCart = new Cart();
            cartRepository.save(newCart);
            return newCart;
        });
    }

    public void addItemToCart(Item item) {
        Cart cart = getCurrentCart();
        cart.addItem(item);
        cartRepository.save(cart);
    }

    public void removeItemFromCart(Item item) {
        Cart cart = getCurrentCart();
        cart.removeItem(item);
        itemRepository.save(item); // Cập nhật lại item sau khi bỏ liên kết cart
        cartRepository.save(cart);
    }

    public double calculateTotalAmount() {
        return getCurrentCart().calculateTotalAmount();
    }
}
