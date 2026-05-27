package com.backend.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerResponseDto {

    private String id;
    private String customerName;
    private String businessName;
    private String phone;
    private String email;
    private String address;
    private String city;
    private LocalDateTime createdAt;
}
