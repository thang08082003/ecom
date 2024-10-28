package com.example.ecommerce.controller;

import com.example.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Hiển thị trang chọn phương thức thanh toán và tổng số tiền
    @GetMapping("/payment")
    public String viewPaymentPage(Model model) {
        double totalAmount = paymentService.calculateTotalAmount(); // Tính tổng số tiền từ PaymentService
        model.addAttribute("totalAmount", totalAmount); // Gửi tổng số tiền đến view
        return "payment"; // Trả về view "payment.html"
    }

    // Xác nhận thanh toán
    @PostMapping("/confirm-payment")
    public String confirmPayment(@RequestParam int paymentMethod, Model model) {
        paymentService.processPayment(paymentMethod);
        model.addAttribute("message", "Payment successful!");
        return "redirect:/shipment"; // Chuyển hướng đến trang shipment
    }
    

}
