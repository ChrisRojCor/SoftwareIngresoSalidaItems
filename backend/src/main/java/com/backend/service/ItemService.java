package com.backend.service;

import com.backend.model.entity.Item;
import com.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;

    }

    public void saveItem(Item item){

        itemRepository.save(item);

    }

    public List<Item> getAllItems() {

        return itemRepository.findAll();

    }

    public Item getItemById(String id){

       return itemRepository.findById(id).orElse(null);

    }

    public void deleteItemById(String id){

        itemRepository.deleteById(id);

    }

}
