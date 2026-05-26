package com.backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDetailRequestDto {

    @NotBlank
    private String itemDescription;

    @Positive
    private int quantity;

    @Positive
    private BigDecimal unitPrice;
}
