package com.backend.model.dto;

import com.backend.model.enums.UserRole;
import lombok.Data;

@Data
public class UserResponseDto {

    private int id;
    private String name;
    private String email;
    private UserRole role;
    private Boolean active;
}
