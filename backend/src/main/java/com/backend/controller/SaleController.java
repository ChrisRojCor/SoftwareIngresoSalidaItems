package com.backend.controller;

import com.backend.model.dto.SaleRequestDto;
import com.backend.model.dto.SaleResponseDto;
import com.backend.security.config.Roles;
import com.backend.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@PreAuthorize("hasRole('" + Roles.ADMIN + "') or hasRole('" + Roles.RECEPTIONIST + "')")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public SaleResponseDto createSale(@Valid @RequestBody SaleRequestDto saleRequestDto) {
        return saleService.createSale(saleRequestDto);
    }

    @GetMapping
    public List<SaleResponseDto> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("{id}")
    public SaleResponseDto getSaleById(@PathVariable Integer id) {
        return saleService.getSaleById(id);
    }

    @DeleteMapping("{id}")
    public void deleteSale(@PathVariable Integer id) {
        saleService.deleteSaleById(id);
    }

    @PutMapping("/{id}")
    public SaleResponseDto updateSale(@PathVariable int id, @Valid @RequestBody SaleRequestDto saleRequestDto) {
        return saleService.updateSale(id, saleRequestDto);
    }
}
