package com.backend.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Sale {

    @Id
    private int orderNumber;
    private BigDecimal amount;
    private BigDecimal discount;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
}
