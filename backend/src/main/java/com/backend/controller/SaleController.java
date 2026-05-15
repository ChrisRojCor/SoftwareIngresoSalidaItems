package com.backend.controller;

import com.backend.model.dto.SaleDTO;
import com.backend.model.dto.SaleResponseDTO;
import com.backend.service.SaleService;
import jakarta.validation.Valid;
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
    public SaleResponseDTO create(@Valid @RequestBody SaleDTO saleDTO) {
        return saleService.saveSale(saleDTO);
    }

    @GetMapping
    public List<SaleResponseDTO> read() {
        return saleService.getAllSales();
    }

    @GetMapping("{id}")
    public SaleResponseDTO readById(@PathVariable Integer id) {
        return saleService.getSaleById(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        saleService.deleteSaleById(id);
    }

    @PutMapping
    public SaleResponseDTO update(@Valid @RequestBody SaleDTO saleDTO) {
        return saleService.saveSale(saleDTO);
    }
}
