package com.sisiback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Sale {

    @Id
    private int orderNumber;
    private int amount;
    private String service;
    private int discount;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
