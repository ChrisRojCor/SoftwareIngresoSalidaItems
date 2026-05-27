package com.backend.model.dto;

import com.backend.model.enums.PaymentMethod;
import com.backend.model.enums.SaleStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleResponseDto {

    private int id;
    private String customerId;
    private int sellerId;
    private BigDecimal discount;
    private BigDecimal tax;
    private BigDecimal subtotal;
    private BigDecimal total;
    private PaymentMethod paymentMethod;
    private SaleStatus status;
    private LocalDateTime createdAt;
    private List<SaleDetailResponseDto> details;
}
