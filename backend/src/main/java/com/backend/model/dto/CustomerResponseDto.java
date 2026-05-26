package com.backend.model.dto;

import lombok.Data;

@Data
public class CustomerResponseDto {

    private String id;
    private String customerName;
    private String businessName;
    private String phone;
    private String contactEmail;
    private String address;
    private String city;
}
