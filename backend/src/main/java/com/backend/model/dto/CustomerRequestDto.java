package com.backend.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequestDto {

    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 100)
    private String customerName;

    @Size(max = 100)
    private String businessName;

    @NotBlank
    @Pattern(regexp = "\\d{10,15}")
    private String phone;

    @NotBlank
    @Email
    private String contactEmail;

    @Size(max = 255)
    private String address;

    @Size(max = 100)
    private String city;
}
