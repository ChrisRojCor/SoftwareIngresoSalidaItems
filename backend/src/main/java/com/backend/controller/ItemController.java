package com.backend.controller;

import com.backend.model.dto.ItemRequestDto;
import com.backend.model.dto.ItemResponseDto;
import com.backend.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemResponseDto create(@Valid @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.saveItem(itemRequestDto);
    }

    @GetMapping
    public List<ItemResponseDto> read() {
        return itemService.getAllItems();
    }

    @GetMapping("{id}")
    public ItemResponseDto readById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        itemService.deleteItemById(id);
    }

    @PutMapping
    public ItemResponseDto update(@Valid @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.saveItem(itemRequestDto);
    }
}
