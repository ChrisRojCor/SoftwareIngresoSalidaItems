package com.backend.mapper;

import com.backend.model.dto.ItemDTO;
import com.backend.model.dto.ItemResponseDTO;
import com.backend.model.entity.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public Item toEntity(ItemDTO dto) {
        Item item = new Item();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setModel(dto.getModel());
        item.setBrand(dto.getBrand());
        return item;
    }

    public ItemResponseDTO toResponseDTO(Item item) {
        ItemResponseDTO dto = new ItemResponseDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setModel(item.getModel());
        dto.setBrand(item.getBrand());
        return dto;
    }

    public List<ItemResponseDTO> toResponseDTOList(List<Item> items) {
        return items.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
