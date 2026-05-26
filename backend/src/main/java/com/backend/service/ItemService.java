package com.backend.service;

import com.backend.model.dto.ItemRequestDto;
import com.backend.model.dto.ItemResponseDto;
import com.backend.mapper.ItemMapper;
import com.backend.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.entity.Item;
import java.util.List;

@Service
@Transactional
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

    public ItemResponseDto updateItem(ItemRequestDto dto) {
        Item item = itemRepository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Item not found: " + dto.getId()));
        itemMapper.merge(item, dto);
        return itemMapper.toResponseDTO(itemRepository.save(item));
    }

    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }
}
