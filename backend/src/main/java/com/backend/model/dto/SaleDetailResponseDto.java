package com.backend.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDetailResponseDto {

    private int id;
    private int saleId;
    private String itemId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal subtotal;
}
