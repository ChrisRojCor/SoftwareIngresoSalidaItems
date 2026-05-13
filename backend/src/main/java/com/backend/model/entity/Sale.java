package com.backend.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Sale {

    @Id
    private int saleNumber;
    private BigDecimal amount;
    private BigDecimal discount;

    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int orderNumber) {
        this.saleNumber = orderNumber;
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
