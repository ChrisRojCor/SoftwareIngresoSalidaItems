package com.backend.controller;

import com.backend.repository.SaleRepository;
import com.backend.model.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;

    @PostMapping("/create")
    public void create(@RequestBody Sale sale){saleRepository.save(sale);}

    @GetMapping("/read")
    public List<Sale> read(){return saleRepository.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){saleRepository.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Sale sale){saleRepository.save(sale);}
}
