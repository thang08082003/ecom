package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Item;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    // Tính tổng số tiền cho giỏ hàng hiện tại
    public double calculateTotalAmount() {
        Cart cart = cartRepository.findById(1).orElseThrow();
        return cart.getItems().stream().mapToDouble(Item::getPrice).sum();
    }

    // Lưu phương thức thanh toán và tổng số tiền vào database
    public void processPayment(int paymentMethod) {
        double totalAmount = calculateTotalAmount();
        Payment payment = new Payment();
        payment.setPaymentMethod(paymentMethod);
        payment.setAmount(totalAmount);
        paymentRepository.save(payment); // Lưu thanh toán vào database
    }
}
