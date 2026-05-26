package com.backend.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SaleRequestDto {

    @NotNull
    @Positive
    private BigDecimal amount;

    @PositiveOrZero
    private BigDecimal discount;

    @Valid
    private List<SaleDetailRequestDto> details;
}
