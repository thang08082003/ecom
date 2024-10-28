package com.example.ecommerce.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCart;

    @OneToMany(mappedBy = "cart", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Item> items = new ArrayList<>();

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setCart(this);
    }

    public void removeItem(Item item) {
        item.setCart(null); // Chỉ xóa liên kết cart mà không xóa item
        items.remove(item);
    }

    public void clear() {
        for (Item item : new ArrayList<>(items)) {
            removeItem(item);
        }
    }

    public double calculateTotalAmount() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
}
