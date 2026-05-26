package com.backend.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleRequestDto {

    @NotNull
    @Positive
    private BigDecimal amount;

    @PositiveOrZero
    private BigDecimal discount;
}
