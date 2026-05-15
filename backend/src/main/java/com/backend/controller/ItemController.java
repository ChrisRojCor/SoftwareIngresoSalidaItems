package com.backend.controller;

import com.backend.model.dto.ItemDTO;
import com.backend.model.dto.ItemResponseDTO;
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
    public ItemResponseDTO create(@Valid @RequestBody ItemDTO itemDTO) {
        return itemService.saveItem(itemDTO);
    }

    @GetMapping
    public List<ItemResponseDTO> read() {
        return itemService.getAllItems();
    }

    @GetMapping("{id}")
    public ItemResponseDTO readById(@PathVariable String id) {
        return itemService.getItemById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        itemService.deleteItemById(id);
    }

    @PutMapping
    public ItemResponseDTO update(@Valid @RequestBody ItemDTO itemDTO) {
        return itemService.saveItem(itemDTO);
    }
}
