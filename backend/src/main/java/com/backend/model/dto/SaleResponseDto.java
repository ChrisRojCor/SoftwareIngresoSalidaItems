package com.backend.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SaleResponseDto {

    private int saleNumber;
    private BigDecimal amount;
    private BigDecimal discount;
    private LocalDate date;
}
