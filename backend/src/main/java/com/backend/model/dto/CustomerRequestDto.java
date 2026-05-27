package com.backend.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequestDto {

    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 100)
    private String customerName;

    @Size(max = 150)
    private String businessName;

    @NotBlank
    @Size(max = 20)
    private String phone;

    @Email
    @Size(max = 150)
    private String email;

    @Size(max = 255)
    private String address;

    @Size(max = 100)
    private String city;
}
