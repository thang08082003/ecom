package com.example.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRating; // Khóa chính cho đánh giá

    private int ratingValue; // Giá trị đánh giá (ví dụ: từ 1 đến 5)

    @ManyToOne // Liên kết nhiều đến một với Customer
    private Customer customer; // Tham chiếu đến khách hàng đã đánh giá

    @ManyToOne // Liên kết nhiều đến một với Item
    private Item item; // Tham chiếu đến sản phẩm được đánh giá

    // Getters và Setters
    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
