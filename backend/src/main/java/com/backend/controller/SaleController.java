package com.backend.controller;

import com.backend.model.dto.SaleRequestDto;
import com.backend.model.dto.SaleResponseDto;
import com.backend.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public SaleResponseDto create(@Valid @RequestBody SaleRequestDto saleRequestDto) {
        return saleService.saveSale(saleRequestDto);
    }

    @GetMapping
    public List<SaleResponseDto> read() {
        return saleService.getAllSales();
    }

    @GetMapping("{id}")
    public SaleResponseDto readById(@PathVariable Integer id) {
        return saleService.getSaleById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        saleService.deleteSaleById(id);
    }

    @PutMapping("/{id}")
    public SaleResponseDto update(@PathVariable int id, @Valid @RequestBody SaleRequestDto saleRequestDto) {
        return saleService.updateSale(id, saleRequestDto);
    }
}
