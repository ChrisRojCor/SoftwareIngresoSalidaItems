package com.backend.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDetailResponseDto {

    private int id;
    private String itemDescription;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal lineTotal;
}
