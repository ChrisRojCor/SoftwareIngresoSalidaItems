package com.backend.controller;

import com.backend.model.dto.ItemRequestDto;
import com.backend.model.dto.ItemResponseDto;
import com.backend.security.config.Roles;
import com.backend.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@PreAuthorize("hasRole('" + Roles.ADMIN + "') or hasRole('" + Roles.RECEPTIONIST + "')")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemResponseDto createItem(@Valid @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.createItem(itemRequestDto);
    }

    @GetMapping
    public List<ItemResponseDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("{id}")
    public ItemResponseDto getItemById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable String id) {
        itemService.deleteItemById(id);
    }

    @PutMapping("/{id}")
    public ItemResponseDto updateItem(@PathVariable String id, @Valid @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.updateItem(id, itemRequestDto);
    }
}
