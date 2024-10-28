package com.example.ecommerce.model;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShipment;

    private int shipMethod;
    private String shippingAddress;
    private Date deliveryDate;

    // Getters and Setters
    public int getIdShipment() {
        return idShipment;
    }

    public void setIdShipment(int idShipment) {
        this.idShipment = idShipment;
    }

    public int getShipMethod() {
        return shipMethod;
    }

    public void setShipMethod(int shipMethod) {
        this.shipMethod = shipMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
