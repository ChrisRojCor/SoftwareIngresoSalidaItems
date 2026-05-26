package com.backend.mapper;

import com.backend.model.dto.UserRequestDto;
import com.backend.model.dto.UserResponseDto;
import com.backend.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setActive(dto.isActive());
        return user;
    }

    public UserResponseDto toResponseDTO(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setActive(user.isActive());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public void merge(User existing, UserRequestDto dto) {
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        existing.setPassword(dto.getPassword());
        existing.setRole(dto.getRole());
        existing.setActive(dto.isActive());
    }

    public List<UserResponseDto> toResponseDTOList(List<User> users) {
        return users.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
