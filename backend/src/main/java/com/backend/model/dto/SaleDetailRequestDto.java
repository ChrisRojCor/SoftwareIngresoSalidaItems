package com.backend.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDetailRequestDto {

    @NotBlank
    private String itemId;

    @Min(1)
    private int quantity = 1;

    @NotNull
    @Positive
    private BigDecimal unitPrice;
}
