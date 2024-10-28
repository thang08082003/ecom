package com.example.ecommerce.controller;

import com.example.ecommerce.model.Shipment;
import com.example.ecommerce.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    // Hiển thị trang chọn phương thức giao hàng và nhập địa chỉ
    @GetMapping("/shipment")
    public String viewShipmentPage(Model model) {
        model.addAttribute("shipment", new Shipment());
        return "shipment"; // Trả về trang shipment.html
    }

    // Xử lý lưu thông tin giao hàng
    @PostMapping("/confirm-shipment")
    public String confirmShipment(
            @RequestParam int shipMethod,
            @RequestParam String shippingAddress,
            Model model) {
        // Tạo và lưu thông tin giao hàng
        Shipment shipment = new Shipment();
        shipment.setShipMethod(shipMethod);
        shipment.setShippingAddress(shippingAddress);
        shipment.setDeliveryDate(new Date()); // Đặt ngày giao hàng dự kiến

        // Lưu thông tin giao hàng vào cơ sở dữ liệu
        shipmentService.saveShipment(shipment);

        // Chuyển hướng đến trang bình luận
        model.addAttribute("shipmentId", shipment.getIdShipment()); // Gửi idShipment để có thể tham chiếu trong trang bình luận
        return "comment"; // Trả về trang comment.html
    }
}
