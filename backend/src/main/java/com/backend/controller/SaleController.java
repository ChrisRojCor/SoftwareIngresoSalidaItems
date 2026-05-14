package com.backend.controller;

import com.backend.model.entity.Sale;
import com.backend.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public void create(@RequestBody Sale sale) {
        saleService.saveSale(sale);
    }

    @GetMapping
    public List<Sale> read() {
        return saleService.getAllSales();
    }

    @GetMapping("{id}")
    public Sale readById(@PathVariable Integer id) {
        return saleService.getSaleById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        saleService.deleteSaleById(id);
    }

    @PutMapping
    public void update(@RequestBody Sale sale) {
        saleService.saveSale(sale);
    }
}
