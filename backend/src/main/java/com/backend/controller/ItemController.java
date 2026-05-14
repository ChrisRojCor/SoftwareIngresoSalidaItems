package com.backend.controller;

import com.backend.model.entity.Item;
import com.backend.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {

        this.itemService = itemService;

    }

    @PostMapping
    public void create(@RequestBody Item item){itemService.saveItem(item);}

    @GetMapping
    public List<Item> read(){ return itemService.getAllItems();}

    @GetMapping("{id}")
    public Item readById(@PathVariable String id){return itemService.getItemById(id);}

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){itemService.deleteItemById(id);}

    @PutMapping
    public void update(@RequestBody Item item){itemService.saveItem(item);}
}
