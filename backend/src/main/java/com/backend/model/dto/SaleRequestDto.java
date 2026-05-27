package com.backend.model.dto;

import com.backend.model.enums.PaymentMethod;
import com.backend.model.enums.SaleStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SaleRequestDto {

    @NotBlank
    private String customerId;

    @Positive
    private int sellerId;

    @NotNull
    @PositiveOrZero
    private BigDecimal discount;

    @NotNull
    @PositiveOrZero
    private BigDecimal tax;

    @NotNull
    @PositiveOrZero
    private BigDecimal subtotal;

    @NotNull
    @PositiveOrZero
    private BigDecimal total;

    @NotNull
    private PaymentMethod paymentMethod;

    @NotNull
    private SaleStatus status;

    @Valid
    private List<SaleDetailRequestDto> details;
}
