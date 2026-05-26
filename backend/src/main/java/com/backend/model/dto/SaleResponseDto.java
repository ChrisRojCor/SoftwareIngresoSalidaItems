package com.backend.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class SaleResponseDto {

    private int saleNumber;
    private BigDecimal amount;
    private BigDecimal discount;
    private LocalDate date;
    private List<SaleDetailResponseDto> details;
}
