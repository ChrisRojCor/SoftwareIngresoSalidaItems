package com.backend.mapper;

import com.backend.model.dto.ItemRequestDto;
import com.backend.model.dto.ItemResponseDto;
import com.backend.model.entity.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public Item toEntity(ItemRequestDto dto) {
        Item item = new Item();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setModel(dto.getModel());
        item.setBrand(dto.getBrand());
        item.setDescription(dto.getDescription());
        return item;
    }

    public ItemResponseDto toResponseDTO(Item item) {
        ItemResponseDto dto = new ItemResponseDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setModel(item.getModel());
        dto.setBrand(item.getBrand());
        dto.setDescription(item.getDescription());
        dto.setCreatedAt(item.getCreatedAt());
        return dto;
    }

    public void merge(Item existing, ItemRequestDto dto) {
        existing.setName(dto.getName());
        existing.setModel(dto.getModel());
        existing.setBrand(dto.getBrand());
        existing.setDescription(dto.getDescription());
    }

    public List<ItemResponseDto> toResponseDTOList(List<Item> items) {
        return items.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
