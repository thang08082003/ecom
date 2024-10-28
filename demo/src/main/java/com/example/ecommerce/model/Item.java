package com.example.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;
    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "cart_id") // Tên cột khóa ngoại trong bảng Item
    private Cart cart; // Tham chiếu đến giỏ hàng

    // Getter và Setter
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
