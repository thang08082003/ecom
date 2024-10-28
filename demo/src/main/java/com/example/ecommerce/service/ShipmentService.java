package com.example.ecommerce.service;

import com.example.ecommerce.model.Shipment;
import com.example.ecommerce.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    // Lưu thông tin giao hàng vào cơ sở dữ liệu
    public void saveShipment(Shipment shipment) {
        // Thiết lập ngày giao hàng (ví dụ: 3 ngày kể từ ngày hôm nay)
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3); // Thêm 3 ngày
        shipment.setDeliveryDate(calendar.getTime()); // Lưu ngày giao hàng

        shipmentRepository.save(shipment);
    }
}
