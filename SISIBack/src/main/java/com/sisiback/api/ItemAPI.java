package com.sisiback.api;

import com.sisiback.dao.ItemDAO;
import com.sisiback.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemAPI {

    @Autowired
    private ItemDAO itemDAO;

    @PostMapping("/create")
    public void create(@RequestBody Item item){itemDAO.save(item);}

    @GetMapping("/read")
    public List<Item> read(){ return itemDAO.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){itemDAO.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Item item){itemDAO.save(item);}
}
