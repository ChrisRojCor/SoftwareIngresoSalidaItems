package com.backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ItemRequestDto {

    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String model;

    @NotBlank
    @Size(max = 100)
    private String brand;
}
