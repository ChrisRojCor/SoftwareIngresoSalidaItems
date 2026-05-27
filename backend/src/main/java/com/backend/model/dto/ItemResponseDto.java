package com.backend.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemResponseDto {

    private String id;
    private String name;
    private String model;
    private String brand;
    private String description;
    private LocalDateTime createdAt;
}
