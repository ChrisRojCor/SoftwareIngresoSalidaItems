package com.backend.service;

import com.backend.model.dto.ItemDTO;
import com.backend.model.dto.ItemResponseDTO;
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

    public ItemResponseDTO saveItem(ItemDTO itemDTO) {
        return itemMapper.toResponseDTO(
                itemRepository.save(
                        itemMapper.toEntity(itemDTO)));
    }

    public List<ItemResponseDTO> getAllItems() {
        return itemMapper.toResponseDTOList(
                itemRepository.findAll());
    }

    public ItemResponseDTO getItemById(String id) {
        return itemMapper.toResponseDTO(
                itemRepository.findById(id).orElse(null));
    }

    public void deleteItemById(String id) {
        itemRepository.deleteById(id);
    }
}
