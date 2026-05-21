package com.backend.service;

import com.backend.model.dto.ItemRequestDto;
import com.backend.model.dto.ItemResponseDto;
import com.backend.mapper.ItemMapper;
import com.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemResponseDto saveItem(ItemRequestDto itemRequestDto) {
        return itemMapper.toResponseDTO(
                itemRepository.save(
                        itemMapper.toEntity(itemRequestDto)));
    }

    public List<ItemResponseDto> getAllItems() {
        return itemMapper.toResponseDTOList(
                itemRepository.findAll());
    }

    public ItemResponseDto getItemById(String id) {
        return itemMapper.toResponseDTO(
                itemRepository.findById(id).orElse(null));
    }

    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }
}
