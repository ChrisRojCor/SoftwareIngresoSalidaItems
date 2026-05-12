package com.backend.controller;

import com.backend.repository.ItemRepository;
import com.backend.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/create")
    public void create(@RequestBody Item item){itemRepository.save(item);}

    @GetMapping("/read")
    public List<Item> read(){ return itemRepository.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable String id){itemRepository.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Item item){itemRepository.save(item);}
}
